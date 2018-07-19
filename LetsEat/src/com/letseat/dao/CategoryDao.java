package com.letseat.dao;

import java.util.List;

import com.letseat.po.Category;

public interface CategoryDao {

	void add(Category category);

	Category find(String id);

	List<Category> getAll();

}