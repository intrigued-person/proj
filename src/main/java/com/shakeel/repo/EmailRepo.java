package com.shakeel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakeel.model.Email;

public interface EmailRepo extends JpaRepository<Email, Long>{

}
