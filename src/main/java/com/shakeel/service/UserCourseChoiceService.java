package com.shakeel.service;

import java.util.List;

import com.shakeel.model.UserCourseChoice;

public interface UserCourseChoiceService {
	void submitCourseChoice(UserCourseChoice choice);

	void updateCourseChoice(UserCourseChoice choice);

	UserCourseChoice getCourseChoiceByUserId(int userId);

	public List<UserCourseChoice> getAllCourseChoices();
}
