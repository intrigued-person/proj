package com.shakeel.repoimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Course;
import com.shakeel.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CourseRepoImp implements CourseRepo{
	
	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourse() {
		return em.createQuery("SELECT c FROM Course c").getResultList();
	}

	@Override
	public boolean updateCourse(Course course) {
		em.merge(course);
		return true;
	}

	@Override
	public void deleteCourse(int id) {
		Course course=em.find(Course.class, id);
		em.remove(course);
		
	}

	@Override
	public void addCourse(Course course) {
		em.persist(course);
	}
	
    public List<Integer> fetchCourseIds() {
        // Create the JPQL query
        String jpql = "select b.courseId from Course b";
        // Create the TypedQuery instance with Integer as the result type
        TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
        // Execute the query and get the result list
        List<Integer> courseIds = query.getResultList();
        return courseIds;
    }

}
