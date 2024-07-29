package com.java.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finalProject.model.DetailBill;

public interface DetailBillRepository extends JpaRepository<DetailBill, Long>{
	List<DetailBill> findByBillsBillId(Long billId);
}
