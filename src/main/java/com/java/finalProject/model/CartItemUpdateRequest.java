package com.java.finalProject.model;

public class CartItemUpdateRequest {
	private String drinkName;
    private int quantity;
    private String tableName;
    
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
