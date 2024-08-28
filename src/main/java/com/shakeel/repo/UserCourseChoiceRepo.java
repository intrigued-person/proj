package com.shakeel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shakeel.model.UserCourseChoice;

public interface UserCourseChoiceRepo extends JpaRepository<UserCourseChoice, Integer> {
    // You can add custom query methods if needed
	UserCourseChoice findByUserId(int userId); 
}
