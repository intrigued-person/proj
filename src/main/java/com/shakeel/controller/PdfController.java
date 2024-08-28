package com.shakeel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shakeel.serviceimp.PdfService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfController {

    private static final String FILE_DIRECTORY = "uploads/";

    @Autowired
    private PdfService pdfService;

    @PostMapping("/generateRankList")
    public ResponseEntity<String> generateRankListPDF() {
        try {
            File file = pdfService.createRankListPDF();
            String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/")
                    .path(file.getName())
                    .toUriString();
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating PDF");
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@PathVariable String filename) throws IOException {
        File file = new File(FILE_DIRECTORY + filename);
        if (file.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .body(java.nio.file.Files.readAllBytes(file.toPath()));
        }
        return ResponseEntity.notFound().build();
    }
}

