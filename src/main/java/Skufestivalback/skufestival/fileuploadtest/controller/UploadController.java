package Skufestivalback.skufestival.fileuploadtest.controller;

import Skufestivalback.skufestival.fileuploadtest.Service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UploadController {

    S3UploadService s3UploadService;

    @Autowired
    public UploadController(S3UploadService s3UploadService) {
        this.s3UploadService = s3UploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handlerFileUpload(@RequestPart("file") MultipartFile file) throws IOException {

        s3UploadService.saveFile(file);

        return ResponseEntity.ok("File uploaded successfully.");
    }
}