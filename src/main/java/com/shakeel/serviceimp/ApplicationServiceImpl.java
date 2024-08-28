package com.shakeel.serviceimp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Application;
import com.shakeel.repo.ApplicationRepo;
import com.shakeel.service.ApplicationService;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepo dao;

	@Override
	public void applyApplication(String name, long mobileNumber, String gender, String dob, String fatherName,
			String motherName, long parentsMobile, String religion, double sslcMark, double twelthmark,
			String degreeType, String address, String state, long pincode, MultipartFile profileImage,int userId,int id)
			throws IOException {
		dao.applyApplication(name, mobileNumber, gender, dob, fatherName, motherName, parentsMobile, religion, sslcMark,
				twelthmark, degreeType, address, state, pincode, profileImage,userId,id);

	}

	@Override
	public List<Application> getAllApplication() {

		return dao.getAllApplication();
	}

	@Override
	public boolean updateApplication(int applicationId,String status) {
		
		boolean flag=true;
		
		try {
			Application application=dao.findById(applicationId);
			if(application != null) {
				application.setStatus(status);
				dao.updateApplication(application);
			}
			
		} catch (Exception e) {
			flag=false;
		}

		return flag;
	}

	@Override
	public void deleteApplication(int applicationId) {
		dao.deleteApplication(applicationId);

	}

	@Override
	public Application findById(int applicationId) {

		return dao.findById(applicationId);
	}

	@Override
	public Application findByUserId(int userId) {
		
		return dao.findByUserId(userId);
	}



	

}
