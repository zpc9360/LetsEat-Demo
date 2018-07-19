package com.letseat.dao;

import java.util.List;

import com.letseat.po.Food;

public interface FoodDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.letseat.dao.impl.FoodDao#add(com.letseat.po.Food)
	 */
	void add(Food food);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.letseat.dao.impl.FoodDao#find(java.lang.String)
	 */
	Food find(String id);

	List<Food> getPageData(int startindex, int pagesize);

	int getTotalRecord();

	List<Food> getPageData(int startindex, int pagesize, String category_id);

	int getTotalRecord(String category_id);

}