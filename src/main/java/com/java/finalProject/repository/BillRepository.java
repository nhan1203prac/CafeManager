package com.java.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finalProject.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
