package com.shakeel.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserReg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;

	private String email;

	private long mobile;

	private String password;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Email> sentEmails;

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Email> receivedEmails;

	public UserReg() {
		// super constructor
	}

	public UserReg(int userId, String userName, String email, long mobile, String password, List<Email> sentEmails,
			List<Email> receivedEmails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.sentEmails = sentEmails;
		this.receivedEmails = receivedEmails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Email> getSentEmails() {
		return sentEmails;
	}

	public void setSentEmails(List<Email> sentEmails) {
		this.sentEmails = sentEmails;
	}

	public List<Email> getReceivedEmails() {
		return receivedEmails;
	}

	public void setReceivedEmails(List<Email> receivedEmails) {
		this.receivedEmails = receivedEmails;
	}

	
}
