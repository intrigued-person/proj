//package com.shakeel.serviceimp;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.shakeel.model.Files;
//import com.shakeel.repo.FileRepository;
//
//
//@Service
//public class FilesService {
//
//	private static final Logger log = LoggerFactory.getLogger(FilesService.class);
//
//	@Autowired
//	private FileRepository fileRepository;
//
//	private final String FILE_PATH = "D:\\pdf";
//
//	public String storeFile(MultipartFile file) throws IOException {
//		Files files = Files
//				.Builder()
//				.name(file.getOriginalFilename())
//				.type(file.getContentType())
//				.imageData(file.getBytes()).build();
//
//		files = fileRepository.save(files);
//
//		log.info("File uploaded successfully into database with id {}", files.getId());
//
//		if (files.getId() != null) {
//			return "File uploaded successfully into database";
//		}
//
//		return null;
//	}
//
//	public byte[] getFiles(String fileName) {
//		return fileRepository.findByName(fileName).getImageData();
//	}
//	
//	public List<Files> getAllFiles() {
//		return fileRepository.findAll();
//	}
//
//	public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
//		String filePath = FILE_PATH + file.getOriginalFilename();
//
//		Files files = Files.Builder().name(file.getOriginalFilename()).path(filePath).type(file.getContentType())
//				.imageData(file.getBytes()).build();
//
//		files = fileRepository.save(files);
//
//		file.transferTo(new File(filePath));
//
//		if (files.getId() != null) {
//			return "File uploaded successfuly into database";
//		}
//
//		return null;
//	}
//
//	public byte[] downloadFilesFromFileSystem(String fileName) throws IOException {
//		String path = fileRepository.findByName(fileName).getPath();
//
//		return java.nio.file.Files.readAllBytes(new File(path).toPath());
//	}
//}

package com.shakeel.serviceimp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Files;
import com.shakeel.repo.FileRepository;

@Service
public class FilesService {

	private static final Logger log = LoggerFactory.getLogger(FilesService.class);

	@Autowired
	private FileRepository fileRepository;

	private final String FILE_PATH = "D:\\pdf";

//	public String storeFile(MultipartFile file) throws IOException {
//		Files files = new Files.Builder().name(file.getOriginalFilename()).type(file.getContentType())
//				.imageData(file.getBytes()).build();
//
//		files = fileRepository.save(files);
//
//		log.info("File uploaded successfully into database with id {}", files.getId());
//
//		if (files.getId() != null) {
//			return "File uploaded successfully into database";
//		}
//
//		return null;
//	}
	
//	 public String storeFile(MultipartFile file) throws IOException {
//	        Files files = new Files.Builder().name(file.getOriginalFilename()).type(file.getContentType())
//	                .imageData(file.getBytes()).build();
//
//	        files = fileRepository.save(files);
//
//	        log.info("File uploaded successfully into database with id {}", files.getId());
//
//	        if (files.getId() != null) {
//	            // Assuming you have a method to generate the URL for the uploaded file
//	            String fileUrl = "/files/" + files.getId(); // Adjust URL format as needed
//	            return fileUrl;
//	        }
//
//	        return null;
//	    }
	
	public String storeFile(MultipartFile file) throws IOException {
	    Files files = new Files.Builder()
	        .name(file.getOriginalFilename())
	        .type(file.getContentType())
	        .path(FILE_PATH)
	        .imageData(file.getBytes())
	        .build();

	    files = fileRepository.save(files);

	    log.info("File uploaded successfully into database with id {}", files.getId());

	    if (files.getId() != null) {
	        // Ensure this URL is correct
	        String fileUrl = "/api/getFileByName/" + files.getName(); 
	        return fileUrl;
	    }

	    return null;
	}



	public byte[] getFiles(String fileName) {
		return fileRepository.findByName(fileName).getImageData();
	}

	public List<Files> getAllFiles() {
		return fileRepository.findAll();
	}

	public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
		String filePath = FILE_PATH + File.separator + file.getOriginalFilename();

		Files files = new Files.Builder().name(file.getOriginalFilename()).path(filePath).type(file.getContentType())
				.imageData(file.getBytes()).build();

		files = fileRepository.save(files);

		file.transferTo(new File(filePath));

		if (files.getId() != null) {
			return "File uploaded successfully into database and file system";
		}

		return null;
	}

	public byte[] downloadFilesFromFileSystem(String fileName) throws IOException {
		String path = fileRepository.findByName(fileName).getPath();
		return java.nio.file.Files.readAllBytes(new File(path).toPath());
	}
	
	
}
