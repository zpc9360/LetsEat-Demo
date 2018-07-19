package com.letseat.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.letseat.dao.UserDao;
import com.letseat.po.Food;
import com.letseat.po.User;
import com.letseat.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{
	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.UserDao#add(com.letseat.po.User)
	 */
	@Override
	public void add(User user) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "insert into user (id,username,password,phone,cellphone,address,email) value(?,?,?,?,?,?,?)";
			Object params[] = { user.getId(), user.getUsername(), user.getPassword(), user.getPhone(),
					user.getCellphone(), user.getAddress(), user.getEmail() };
			runner.update(sql, params);
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.UserDao#find(java.lang.String)
	 */
	@Override
	@SuppressWarnings({ "deprecation", "unused" })
	public User find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from user where id=?";
			return (User) runner.query(sql, id, new BeanHandler(User.class));

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}
	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	@SuppressWarnings({ "deprecation" })
	public User find(String username, String password) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] ={username,password};
			return (User) runner.query(sql, params, new BeanHandler(User.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
