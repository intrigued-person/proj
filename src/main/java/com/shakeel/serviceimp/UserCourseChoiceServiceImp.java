package com.shakeel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shakeel.model.UserCourseChoice;
import com.shakeel.repo.UserCourseChoiceRepo;
import com.shakeel.service.UserCourseChoiceService;

//In UserCourseChoiceServiceImp.java
@Service
public class UserCourseChoiceServiceImp implements UserCourseChoiceService {
	@Autowired
	private UserCourseChoiceRepo repo;

	@Transactional
	@Override
	public void submitCourseChoice(UserCourseChoice choice) {
		repo.save(choice);
	}

	@Transactional
	@Override
	public void updateCourseChoice(UserCourseChoice choice) {
		repo.save(choice);
	}

	@Override
	public UserCourseChoice getCourseChoiceByUserId(int userId) {
		return repo.findByUserId(userId); // Add a method in the repository
	}

	public List<UserCourseChoice> getAllCourseChoices() {
		return repo.findAll();
	}
}
