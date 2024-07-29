package com.java.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.finalProject.model.carts;

import jakarta.transaction.Transactional;

public interface CartRepository extends JpaRepository<carts, Long>{
	@Query("SELECT DISTINCT c.tableName FROM carts c")
    List<String> findDistinctTableNames();
	List<carts> findByTableName(String tableName);
	
	carts findByDrinkNameAndTableName(String drinkName, String tableName);
	@Transactional
	int deleteByTableName(String tableName);
}
