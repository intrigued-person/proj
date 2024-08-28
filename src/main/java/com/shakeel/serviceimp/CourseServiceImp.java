package com.shakeel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shakeel.model.Course;
import com.shakeel.repo.CourseRepo;
import com.shakeel.service.CourseService;

@Service
public class CourseServiceImp implements CourseService {
    
    @Autowired
    private CourseRepo repo;

    @Transactional
    @Override
    public void insertCourse(Course course) {
        repo.addCourse(course);
    }

    @Transactional
    @Override
    public boolean updateCourse(Course course) {
        return repo.updateCourse(course); 
    }

    @Transactional
    @Override
    public void deleteCourse(int id) {
        repo.deleteCourse(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return repo.getAllCourse();
    }

	@Override
	public List<Integer> getAllCids() {
		return repo.fetchCourseIds();
	}
}

