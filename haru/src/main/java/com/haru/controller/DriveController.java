package com.haru.controller;

import com.haru.service.GoogleDriveService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/settings/backAndRecover")
public class DriveController {

    @Autowired
    private GoogleDriveService googleDriveService;

    @GetMapping("/list")
    public ResponseEntity<List<com.google.api.services.drive.model.File>> listFiles() {
        try {
            List<com.google.api.services.drive.model.File> files = googleDriveService.listFiles();
            return ResponseEntity.ok(files);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") java.io.File file) {
        try {
            com.google.api.services.drive.model.File uploadedFile = googleDriveService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + uploadedFile.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file");
        }
    }

    @PostMapping("/download")
    public ResponseEntity<String> downloadFile(@RequestParam("fileId") String fileId, @RequestParam("destinationPath") String destinationPath) {
        try {
            File destinationFile = new File(destinationPath);
            googleDriveService.downloadFile(fileId, destinationFile);
            return ResponseEntity.ok("File downloaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error downloading file");
        }
    }
}
