package com.shakeel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shakeel.model.Course;
import com.shakeel.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

	@Autowired
	CourseService service;

	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		service.insertCourse(course);
		return "Course Object Saved";
		
	}

	@GetMapping("/getAllCourses")
	public List<Course> getAllCourse() {
		return service.getAllCourse();

	}

	@PutMapping("/courseUpdate")
	public String courseUpdate(@RequestBody Course course) {
		service.updateCourse(course);

		return "Course Object Updated";
		 
	}

	@DeleteMapping("/courseDelete/{id}")
	public ResponseEntity<String> courseDelete(@PathVariable("id") int id) {

		try {
			service.deleteCourse(id);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("failed");
		}
	}
	
	@GetMapping("/cidList")
	public List<Integer> getAllCids(){
		return service.getAllCids();
		
	}
	
	
	

}
