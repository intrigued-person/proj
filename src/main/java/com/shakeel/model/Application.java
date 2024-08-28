package com.shakeel.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationId;

	private String name;

	private long mobileNumber;

	private String gender;

	private String dob;

	private String fatherName;

	private String motherName;

	private long parentsMobile;

	private String religion;

	private double sslcMark;

	private double twelthmark;

	private String degreeType;

	private String address;

	private String state;

	private long pincode;

	private String status;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] profileImage;

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	@ManyToOne
	private Departments department;

	@OneToOne(targetEntity = UserReg.class)
	private UserReg user;

	public Application() {
		//super constructor
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public double getTwelthmark() {
		return twelthmark;
	}

	public void setTwelthmark(double twelthmark) {
		this.twelthmark = twelthmark;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getParentsMobile() {
		return parentsMobile;
	}

	public void setParentsMobile(long parentsMobile) {
		this.parentsMobile = parentsMobile;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public double getSslcMark() {
		return sslcMark;
	}

	public void setSslcMark(double sslcMark) {
		this.sslcMark = sslcMark;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserReg getUser() {
		return user;
	}

	public void setUser(UserReg user) {
		this.user = user;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", dob=" + dob + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", parentsMobile=" + parentsMobile + ", religion=" + religion + ", sslcMark=" + sslcMark
				+ ", twelthmark=" + twelthmark + ", degreeType=" + degreeType + ", address=" + address + ", state="
				+ state + ", pincode=" + pincode + ", status=" + status + ", profileImage="
				+ Arrays.toString(profileImage) + ", department=" + department + ", user=" + user + "]";
	}

}
