package com.java.finalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "drinksMenu")
public class DrinksMenu {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long drinkId;
	private String drinkName;
	private double price;
	@ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private category cate;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(Long drinkId) {
		this.drinkId = drinkId;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public category getCate() {
		return cate;
	}
	public void setCate(category cate) {
		this.cate = cate;
	}
	
}
