package com.shakeel.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emaildb")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emailId;

	@ManyToOne
	@JoinColumn(name = "sender_id", nullable = false)
	private UserReg sender;

	@ManyToOne
	@JoinColumn(name = "receiver_id", nullable = false)
	private UserReg receiver;


	@Column(nullable = false)
	private String subject;

	@Column(nullable = false)
	private String body;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentAt;

	public Long getEmailId() {

		return emailId;

	}

	public void setEmailId(Long emailId) {

		this.emailId = emailId;

	}

	public UserReg getSender() {
		return sender;

	}

	public void setSender(UserReg sender) {
		this.sender = sender;

	}

	public UserReg getReceiver() {
		return receiver;
	}

	public void setReceiver(UserReg receiver) {
		this.receiver = receiver;

	}

	public String getSubject() {
		return subject;

	}

	public void setSubject(String subject) {
		this.subject = subject;

	}

	public String getBody() {
		return body;

	}

	public void setBody(String body) {
		this.body = body;

	}

	public Date getSentAt() {
		return sentAt;

	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;

	}

}
