package com.shakeel.repoimp;

import java.io.IOException;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Application;
import com.shakeel.model.Departments;
import com.shakeel.model.UserReg;
import com.shakeel.repo.ApplicationRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ApplicationRepoImp implements ApplicationRepo {

	@Autowired
	EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getAllApplication() {

		return em.createQuery("from Application").getResultList();
	}

	@Override
	public void updateApplication(Application application) {

		em.merge(application);
	}

	@Override
	public void deleteApplication(int id) {
		//yet to implement
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Application findById(int applicationId) {
		Query<Application> q = (Query<Application>) em.createQuery("from Application where applicationId = ?1");
		q.setParameter(1, applicationId);
		return (Application) q.getSingleResult();
	}

	@Override
	public void applyApplication(String name, long mobileNumber, String gender, String dob, String fatherName,
			String motherName, long parentsMobile, String religion, double sslcMark, double twelthmark,
			String degreeType, String address, String state, long pincode, MultipartFile profileImage, int userId,
			int id) {

		

		UserReg reg = em.find(UserReg.class, userId);
		Departments dept = em.find(Departments.class, id);

		

		try {
			Application app = new Application();
			app.setName(name);
			app.setMobileNumber(mobileNumber);
			app.setGender(gender);
			app.setDob(dob);
			app.setFatherName(fatherName);
			app.setMotherName(motherName);
			app.setParentsMobile(parentsMobile);
			app.setReligion(religion);
			app.setSslcMark(sslcMark);
			app.setTwelthmark(twelthmark);
			app.setDegreeType(degreeType);
			app.setAddress(address);
			app.setState(state);
			app.setPincode(pincode);
			app.setStatus("Applied");
			app.setUser(reg);
			app.setDepartment(dept);
			app.setProfileImage(profileImage.getBytes());

			em.persist(app);
		} catch (IOException e) {
			System.out.println("Error while applying");
		}

	}

	@Override
	public Application findByUserId(int userId) {
		try {
			Query<Application> query = (Query<Application>) em.createQuery("from Application where user.userId = ?1", Application.class).setParameter(1, userId);
			 return query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}

	}
	
}
