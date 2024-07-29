package com.java.finalProject.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detailBill")
public class DetailBill {
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long detailBillId;
		 	@ManyToOne
		    @JoinColumn(name = "billId", referencedColumnName = "billId")
		    private Bill bills;
			
		 	@ManyToOne
		    @JoinColumn(name = "drinkId", referencedColumnName = "drinkId")
		    private DrinksMenu drinkMenu;
		 	private double price;
		 	private int quantity;
			public Long getDetailBillId() {
				return detailBillId;
			}
			public void setDetailBillId(Long detailBillId) {
				this.detailBillId = detailBillId;
			}
			public Bill getBills() {
				return bills;
			}
			public void setBills(Bill bills) {
				this.bills = bills;
			}
			public DrinksMenu getDrinkMenu() {
				return drinkMenu;
			}
			public void setDrinkMenu(DrinksMenu drinkMenu) {
				this.drinkMenu = drinkMenu;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
		 	
		 	
		 	
		 	
	}


