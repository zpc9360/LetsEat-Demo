package com.letseat.service;

import java.util.List;

import com.letseat.po.Category;
import com.letseat.po.Food;

public interface BusinessService {

	/**添加分类**/
	void addCategory(Category category);

	/**查找分类**/
	Category findCategory(String id);

	/**得到所有分类**/
	List<Category> getAllCategory();

	void addFood(Food food);

}