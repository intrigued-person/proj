package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Course;


public interface CourseRepo {
	
	public void addCourse(Course course);
	
	public List<Course> getAllCourse();

	public boolean updateCourse(Course course);
	
	public void deleteCourse(int id);
	
	public List<Integer> fetchCourseIds();
	
	
	
	}
