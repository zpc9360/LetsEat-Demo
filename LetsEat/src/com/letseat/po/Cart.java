package com.letseat.po;

import java.util.HashMap;
import java.util.Map;



public class Cart {
	private Map<String,CartItem> map = new HashMap<String, CartItem>();
	private double price;
	
	
	public void add(Food food) {
		CartItem item = map.get(food.getId());
		if(item==null) {
			item = new CartItem();
			item.setFood(food);
			item.setQuantity(1);
			map.put(food.getId(), item);
		}else {
			item.setQuantity(item.getQuantity()+1);
		}
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double totalprice=0;
		for(Map.Entry<String,CartItem> me : map.entrySet()) {
			CartItem item = me.getValue();
			totalprice=totalprice+item.getPrice();
		}
		this.price=totalprice;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
