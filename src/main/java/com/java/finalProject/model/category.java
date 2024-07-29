package com.java.finalProject.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class category {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	private String categoryName;
	private String description;
	@OneToMany(mappedBy = "cate") // mappedBy sẽ trỏ đến tên trường User trong lớp Order
	@JsonBackReference
	private List<DrinksMenu> drinksMenu = new ArrayList<>();
	
	public List<DrinksMenu> getDrinksMenu() {
		return drinksMenu;
	}
	public void setDrinksMenu(List<DrinksMenu> drinksMenu) {
		this.drinksMenu = drinksMenu;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
