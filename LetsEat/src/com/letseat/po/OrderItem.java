package com.letseat.po;

public class OrderItem {
	
	private String id;
	private Food food;
	private int quantity;
	private double price;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
