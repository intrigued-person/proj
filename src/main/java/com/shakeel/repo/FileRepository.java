package com.shakeel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakeel.model.Files;

public interface FileRepository extends JpaRepository<Files, Long> {

	Files findByName(String name);
}