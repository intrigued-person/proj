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

import com.shakeel.model.UserReg;
import com.shakeel.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addUser")
	public String userRegister(@RequestBody UserReg user) {
		service.addUser(user);
		return "User Object Saved";
		 
	}

	@GetMapping("/studentLogin/{email}/{password}")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			UserReg user=service.studentLogin(email, password);
			if(user != null) {
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			System.out.println("Error user login");
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}

	@GetMapping("/getUsers")
	public List<UserReg> getAll() {
		return service.getAllUsers();

	}
	
	@PutMapping("/userUpdate")
	public String userUpadet(@RequestBody UserReg user) {
		service.updateUser(user);
		return "User Object Updated";
	
	}
}
