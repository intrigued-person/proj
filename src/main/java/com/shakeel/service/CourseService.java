package com.shakeel.service;

import java.util.List;

import com.shakeel.model.Course;

public interface CourseService {
	
	public void insertCourse(Course course);
	
	public boolean updateCourse(Course course);
	
	public void deleteCourse(int id);
	
	public List<Course> getAllCourse();
	
	public List<Integer> getAllCids();
	
	
	
	

}
