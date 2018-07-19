package com.letseat.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.letseat.dao.CategoryDao;
import com.letseat.po.Category;
import com.letseat.utils.JdbcUtils;
import com.mchange.v2.c3p0.impl.DefaultConnectionTester.QuerylessTestRunner;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void add(Category category) {

		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "insert into category (id,name,description) value(?,?,?)";
			Object params[] = { category.getId(), category.getName(), category.getDescription() };
			runner.update(sql, params);
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public Category find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from category where id= ?";
			return (Category) runner.query(sql, id, new BeanHandler(Category.class));
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from category";
			return  (List<Category>) runner.query(sql, new BeanListHandler(Category.class));
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}
}
