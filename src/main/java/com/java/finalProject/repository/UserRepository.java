package com.java.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finalProject.model.users;


public interface UserRepository extends JpaRepository<users, Long>{
	users findByUsername(String username);
}
