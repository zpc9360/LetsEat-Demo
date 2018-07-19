package com.letseat.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.letseat.dao.FoodDao;
import com.letseat.po.Food;
import com.letseat.utils.JdbcUtils;

public class FoodDaoImpl implements FoodDao{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.letseat.dao.impl.FoodDao#add(com.letseat.po.Food)
	 */
	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.FoodDao#add(com.letseat.po.Food)
	 */
	@Override
	public void add(Food food) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "insert into food (id,name,store,price,image,description,category_id) value(?,?,?,?,?,?,?)";
			Object params[] = { food.getId(), food.getName(), food.getStore(), food.getPrice(), food.getImage(),
					food.getDescription(), food.getCategory_id() };
			runner.update(sql, params);
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.letseat.dao.impl.FoodDao#find(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.FoodDao#find(java.lang.String)
	 */
	@Override
	@SuppressWarnings("deprecation")
	public Food find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from food where id=?";
			return (Food) runner.query(sql, id, new BeanHandler(Food.class));

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.FoodDao#getPageData(int, int)
	 */
	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Food> getPageData(int startindex, int pagesize) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from food limit ?,?";
			Object params[] = { startindex, pagesize };
			return (List<Food>) runner.query(sql, params, new BeanListHandler(Food.class));
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.FoodDao#getTotalRecord()
	 */
	@Override
	public int getTotalRecord() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select count(*) from food";
			long TotalRecord = (Long) runner.query(sql ,new ScalarHandler());
			return (int)TotalRecord;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}
/* (non-Javadoc)
 * @see com.letseat.dao.impl.FoodDao#getPageData(int, int, java.lang.String)
 */
@Override
@SuppressWarnings({ "deprecation", "unchecked" })
public List<Food> getPageData(int startindex,int pagesize,String category_id){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from food where category_id=? limit ?,?";
			Object params[] = {category_id,startindex,pagesize};
			return (List<Food>) runner.query(sql, params, new BeanListHandler(Food.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.FoodDao#getTotalRecord(java.lang.String)
	 */
	@Override
	public int getTotalRecord(String category_id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			
			String sql = "select count(*) from food where category_id=?";
			long totalrecord = (Long) runner.query(sql, category_id,new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
