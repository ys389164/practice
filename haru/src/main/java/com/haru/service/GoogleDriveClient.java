package com.haru.service;

import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

@Component
public class GoogleDriveClient {

    private final Drive driveService;

    public GoogleDriveClient(@Value("${spring.security.oauth2.client.registration.google.client-id}") String clientId,
                             @Value("${spring.security.oauth2.client.registration.google.client-secret}") String clientSecret) {

        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        try {
            GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("path/to/credentials.json"))
                    .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));

            this.driveService = new Drive.Builder(httpTransport, jsonFactory, credential)
                    .setApplicationName("Your Application Name")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Google Drive client", e);
        }
    }

    public void backupData() throws IOException {
        java.io.File filePath = new java.io.File("path/to/your/file.txt"); // Local file to upload
        File fileMetadata = new File();
        fileMetadata.setName("file.txt");
        FileContent mediaContent = new FileContent("text/plain", filePath);

        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        System.out.println("File ID: " + file.getId());
    }

    public void restoreData(String fileId) throws IOException {
        File file = driveService.files().get(fileId).execute();
        // Implement file download logic here

        System.out.println("File Name: " + file.getName());
    }
}
