package com.shakeel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shakeel.model.UserCourseChoice;
import com.shakeel.service.UserCourseChoiceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserCourseChoiceController {

	@Autowired
	private UserCourseChoiceService service;

	@PostMapping("/submitCourseChoice")
	public ResponseEntity<String> submitCourseChoice(@RequestBody UserCourseChoice choice) {
		try {
			service.submitCourseChoice(choice);
			return ResponseEntity.ok("Course choice submitted successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to submit course choice");
		}
	}

	@PutMapping("/updateCourseChoice")
	public ResponseEntity<String> updateCourseChoice(@RequestBody UserCourseChoice choice) {
		try {
			service.updateCourseChoice(choice);
			return ResponseEntity.ok("Course choice updated successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to update course choice");
		}
	}

	@GetMapping("/courseChoice/{userId}")
	public ResponseEntity<UserCourseChoice> getCourseChoiceByUserId(@PathVariable int userId) {
		UserCourseChoice choice = service.getCourseChoiceByUserId(userId);
		if (choice != null) {
			return ResponseEntity.ok(choice);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/courseChoices")
	public ResponseEntity<List<UserCourseChoice>> getAllCourseChoices() {
		try {
			List<UserCourseChoice> choices = service.getAllCourseChoices();
			return ResponseEntity.ok(choices);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
