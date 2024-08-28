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

import com.shakeel.model.Staff;
import com.shakeel.service.StaffService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {

	@Autowired
	StaffService service;

	@PostMapping("/addStaff")
	public ResponseEntity<String> addStaff(@RequestBody Staff staff) {

		try {
			service.addStaff(staff);

			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed");
		}

	}

	@GetMapping("/getAllStaffs")
	public List<Staff> getAllStaffs() {
		return service.getAllStaff();

	}

	@GetMapping("/staffLogin/{staffName}/{password}")
	public ResponseEntity<?> staffLogin(@PathVariable("staffName") String staffName,
			@PathVariable("password") String password) {

		try {
			Staff staff = service.staffLogin(staffName, password);
			if (staff != null) {
				return ResponseEntity.ok(staff);
			}
		} catch (Exception e) {
			System.out.println("Error while login");

		}

		return (ResponseEntity<?>) ResponseEntity.badRequest();

	}

	@PutMapping("/staffUpdate")
	public ResponseEntity<String> userUpadet(@RequestBody Staff staff) {
		try {
			service.updateStaff(staff);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Fail");
		}
	}

	@DeleteMapping("deleteStaff/{staffId}")
	public ResponseEntity<String> deleteStaff(@PathVariable("staffId") int staffId) {
		try {
			service.deleteStaff(staffId);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Fail");
		}
	}

}
