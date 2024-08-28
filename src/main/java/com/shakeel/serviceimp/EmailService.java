package com.shakeel.serviceimp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Email;
import com.shakeel.model.UserReg;
import com.shakeel.repo.EmailRepo;
import com.shakeel.repo.UserRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private EmailRepo emailRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	private final String fromEmail = "noreply@yourdomain.com"; // Specify sender email

	public void sendEmail(String from, String to, String subject, String text, MultipartFile attachment)
			throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);

		if (attachment != null && !attachment.isEmpty()) {
			helper.addAttachment(attachment.getOriginalFilename(), new ByteArrayResource(attachment.getBytes()));
		}

		javaMailSender.send(mimeMessage);

		UserReg sender = userRepo.findByEmail(from)
				.orElseThrow(() -> new RuntimeException("Sender not found: " + from));
		UserReg receiver = userRepo.findByEmail(to)
				.orElseThrow(() -> new RuntimeException("Receiver not found: " + to));

		Email email = new Email();
		email.setSender(sender);
		email.setReceiver(receiver);
		email.setSubject(subject);
		email.setBody(text);
		email.setSentAt(new Date());

		emailRepo.save(email);
	}

	public void sendEmailToAllUsers(String subject, String body, MultipartFile attachment)
			throws MessagingException, IOException {
		List<UserReg> allUsers = userRepo.getAllUsers();

		UserReg fromUser = userRepo.findByEmail(fromEmail)
				.orElseThrow(() -> new RuntimeException("Sender not found: " + fromEmail));

		for (UserReg user : allUsers) {
			sendEmail(fromEmail, user.getEmail(), subject, body, attachment); // Send email

			// Save email to database
			Email email = new Email();
			email.setSender(fromUser); // Ensure this is not null
			email.setReceiver(user);
			email.setSubject(subject);
			email.setBody(body);
			email.setSentAt(new Date());

			emailRepo.save(email);
		}
	}

}
