package com.shakeel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.serviceimp.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestParam String from, @RequestParam String to,
			@RequestParam String subject, @RequestParam String body,
			@RequestParam(required = false) MultipartFile attachment) {
		try {

			emailService.sendEmail(from, to, subject, body, attachment);
			return ResponseEntity.ok("Email sent successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}


	@PostMapping("/sendEmailToAll")
	public ResponseEntity<String> sendEmailsToAll(@RequestParam String subject, @RequestParam String body,
			@RequestParam(required = false) MultipartFile attachment) {
		try {
			emailService.sendEmailToAllUsers(subject, body, attachment);
			return ResponseEntity.ok("Emails sent to all users successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send emails: " + e.getMessage());
		}
	}

}
