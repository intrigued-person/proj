package com.shakeel.repo;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Application;

public interface ApplicationRepo {

	public void applyApplication(String name, long mobileNumber, String gender, String dob, String fatherName,
			String motherName, long parentsMobile, String religion, double sslcMark, double twelthmark,
			String degreeType, String address, String state, long pincode, MultipartFile profileImage, int userId,
			int id) throws IOException;

	public List<Application> getAllApplication();

	public void updateApplication(Application application);

	public void deleteApplication(int applicationId);

	public Application findById(int applicationId);

	public Application findByUserId(int userId);
	

}
