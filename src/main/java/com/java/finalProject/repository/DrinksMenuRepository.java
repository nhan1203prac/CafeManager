package com.java.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finalProject.model.DrinksMenu;
import com.java.finalProject.model.tables;

public interface DrinksMenuRepository extends JpaRepository<DrinksMenu, Long>{
	List<DrinksMenu> findByCateCategoryId(Long categoryId);
	DrinksMenu findByDrinkName(String drinkName);
}
