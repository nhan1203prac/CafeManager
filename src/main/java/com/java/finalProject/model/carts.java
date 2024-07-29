package com.java.finalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")
public class carts {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String drinkName;
	    
	    private double drinkPrice;
	    
	    private String drinkImage;
	    
	    private int quantity;
	    
	    private String tableName;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDrinkName() {
			return drinkName;
		}

		public void setDrinkName(String drinkName) {
			this.drinkName = drinkName;
		}

		public double getDrinkPrice() {
			return drinkPrice;
		}

		public void setDrinkPrice(double drinkPrice) {
			this.drinkPrice = drinkPrice;
		}

		public String getDrinkImage() {
			return drinkImage;
		}

		public void setDrinkImage(String drinkImage) {
			this.drinkImage = drinkImage;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
	    
	    
	    
}
