package com.letseat.dao;

import java.util.List;

import com.letseat.po.Order;

public interface OrderDao {

	void add(Order order);

	Order find(String id);

	List<Order> getAll(boolean state);

	void update(Order order);

}