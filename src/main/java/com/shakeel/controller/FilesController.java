//package com.shakeel.controller;
//
//import java.io.IOException;
//import org.springframework.http.HttpHeaders;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.shakeel.model.Files;
//import com.shakeel.serviceimp.FilesService;
//
//
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin
//public class FilesController {
//	
//	private static final Logger log = LoggerFactory.getLogger(FilesService.class);
//	
//	@Autowired
//	private FilesService filesService;
//	
//	@PostMapping("/uploadFilesIntoDB")
//	public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
//		log.info("Enter into uploadFilesIntoDB method");
//		
//		String response = filesService.storeFile(file);
//		
//		log.info("Completed uploadFilesIntoDB method with response {}", response);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
//	
//	@GetMapping("/getFileByName/{fileName}")
//	public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
//		byte[] imageData = filesService.getFiles(fileName);
//		
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//	}
//	
//	@GetMapping("/files")
//	public ResponseEntity<List<Files>> getAllFiles() {
//		List<Files> imageData = filesService.getAllFiles();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(imageData);
//	}
//	
//	@PostMapping("/uploadFilesIntoFileSystem")
//	public ResponseEntity<String> uploadFileIntoFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
//		String response = filesService.storeDataIntoFileSystem(file);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
//	
//	@GetMapping("/getFilesFromFileSystem/{fileName}")
//	public ResponseEntity<byte[]> downloadImageFromFileSystem(@PathVariable String fileName) {
//		byte[] imageData = filesService.getFiles(fileName);
//		
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//	}
//	
//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
//        byte[] fileData = filesService.getFileData(id);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
//    }
//
//}
package com.shakeel.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Files;
import com.shakeel.serviceimp.FilesService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilesController {

    private static final Logger log = LoggerFactory.getLogger(FilesController.class);

    @Autowired
    private FilesService filesService;

    @PostMapping("/uploadFilesIntoDB")
    public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("Entering uploadFilesIntoDB method");

        String fileUrl = filesService.storeFile(file);

        log.info("Completed uploadFilesIntoDB method with URL {}", fileUrl);

        if (fileUrl != null) {
            return ResponseEntity.status(HttpStatus.OK).body(fileUrl);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }


    
    @GetMapping("/getFileByName/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        log.info("Fetching file data for {}", fileName);
        
        byte[] imageData = filesService.getFiles(fileName);

        // Assume image files are either PNG or JPEG; adjust based on actual content
        MediaType mediaType = MediaType.valueOf(fileName.endsWith(".png") ? "image/png" : "image/jpeg");

        return ResponseEntity.status(HttpStatus.OK).contentType(mediaType).body(imageData);
    }

    @GetMapping("/files")
    public ResponseEntity<List<Files>> getAllFiles() {
        log.info("Fetching all files");
        
        List<Files> files = filesService.getAllFiles();

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @PostMapping("/uploadFilesIntoFileSystem")
    public ResponseEntity<String> uploadFileIntoFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("Entering uploadFileIntoFileSystem method");

        String response = filesService.storeDataIntoFileSystem(file);

        log.info("Completed uploadFileIntoFileSystem method with response {}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getFilesFromFileSystem/{fileName}")
    public ResponseEntity<byte[]> downloadImageFromFileSystem(@PathVariable String fileName) {
        log.info("Fetching file from file system for {}", fileName);
        
        byte[] imageData;
        try {
            imageData = filesService.downloadFilesFromFileSystem(fileName);
        } catch (IOException e) {
            log.error("Error fetching file from file system", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        // Assume image files are either PNG or JPEG; adjust based on actual content
        MediaType mediaType = MediaType.valueOf(fileName.endsWith(".png") ? "image/png" : "image/jpeg");

        return ResponseEntity.status(HttpStatus.OK).contentType(mediaType).body(imageData);
    }

    // Remove or update this method if not needed
    // @GetMapping("/{id}")
    // public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
    //     byte[] fileData = filesService.getFileData(id);
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_PDF);
    //     return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    // }
}
