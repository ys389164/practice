package com.haru.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonClientRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class GoogleDriveService {

    private static final String APPLICATION_NAME = "My Application";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "/path/to/credentials.json"; // OAuth 2.0 클라이언트 비밀번호 파일 경로

    private final Drive driveService;

    public GoogleDriveService() throws GeneralSecurityException, IOException {
        this.driveService = getDriveService();
    }

    private Drive getDriveService() throws GeneralSecurityException, IOException {
        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(CREDENTIALS_FILE_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public List<File> listFiles() throws IOException {
        FileList result = driveService.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return result.getFiles();
    }

    public File uploadFile(java.io.File file) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(file.getName());

        FileContent mediaContent = new FileContent("application/octet-stream", file);

        return driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
    }

    public void downloadFile(String fileId, java.io.File destinationFile) throws IOException {
        Drive.Files.Get request = driveService.files().get(fileId);
        try (java.io.OutputStream outputStream = new java.io.FileOutputStream(destinationFile)) {
            request.executeMediaAndDownloadTo(outputStream);
        }
    }
}
