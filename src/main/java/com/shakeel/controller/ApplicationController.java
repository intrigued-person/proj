package com.shakeel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Application;
import com.shakeel.service.ApplicationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {

	@Autowired
	ApplicationService service;

	@PostMapping("/applyApplication")
	public ResponseEntity<String> applyApplication(@RequestParam String name, @RequestParam long mobileNumber,
			@RequestParam String gender, @RequestParam String dob, @RequestParam String fatherName,
			@RequestParam String motherName, @RequestParam long parentsMobile, @RequestParam String religion,
			@RequestParam double sslcMark, @RequestParam double twelthmark, @RequestParam String degreeType,
			@RequestParam String address, @RequestParam String state, @RequestParam long pincode,
			@RequestParam MultipartFile profileImage, @RequestParam int userId, @RequestParam int id) {
		try {

			
			service.applyApplication(name, mobileNumber, gender, dob, fatherName, motherName, parentsMobile, religion,
					sslcMark, twelthmark, degreeType, address, state, pincode, profileImage, userId, id);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("failed");

		}

	}

	@GetMapping("/getAllApplications")
	public List<Application> getAllApplications(Application applications) {
		return service.getAllApplication();
	}

	@GetMapping("/findByID/{applicationId}")
	public Application getApplicationById(@PathVariable("applicationId") int applicationId) {
		return service.findById(applicationId);
	}

	@PostMapping("/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestParam int applicationId, @RequestParam String status) {

		try {
			service.updateApplication(applicationId, status);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("failed");
		}

	}

	@GetMapping("/findApplicationByUserId/{userId}")
	public Application findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

}
