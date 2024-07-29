package com.java.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finalProject.model.category;

public interface CategoryRepository extends JpaRepository<category, Long>{
	
}
