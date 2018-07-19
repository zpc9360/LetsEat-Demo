package com.letseat.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.Messaging.SyncScopeHelper;

import com.letseat.dao.OrderDao;
import com.letseat.po.Food;
import com.letseat.po.Order;
import com.letseat.po.OrderItem;
import com.letseat.po.User;
import com.letseat.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.OrderDao#add(com.letseat.po.Order)
	 */
	@Override
	public void add(Order order) {

		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());

			String sql = "insert into orders(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
			Object params[] = { order.getId(), order.getOrdertime(), order.getPrice(), order.isState(),
					order.getUser().getId() };
			runner.update(sql, params);
			
			Set<OrderItem> set = order.getOrderitems();
			for (OrderItem item : set) {
				sql = "insert into orderitem(id,quantity,price,Food_id,order_id) values(?,?,?,?,?)";
				params = new Object[] { item.getId(), item.getQuantity(), item.getPrice(), item.getFood().getId(),
						order.getId() };
				runner.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.OrderDao#find(java.lang.String)
	 */
	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Order find(String id) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			//1.找出订单的基本信息
			String sql = "select * from orders where id=?";
			Order order = (Order) runner.query(sql, id, new BeanHandler(Order.class));
			//2.找出订单中所有订单项
			sql = "select * from orderitem where order_id=?";
			List<OrderItem> list = (List<OrderItem>) runner.query(sql, id, new BeanListHandler(OrderItem.class));
			for(OrderItem item : list){
				sql = "select food.* from orderitem,food where orderitem.id=? and orderitem.food_id=food.id";
				Food food = (Food) runner.query(sql, item.getId(), new BeanHandler(Food.class));
				item.setFood(food);
			}
			//把找出的订单项放进order
			order.getOrderitems().addAll(list);
			
			//3.订单属于哪个用户
			sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
			User user = (User) runner.query(sql,order.getId(), new BeanHandler(User.class));
			order.setUser(user);
			
			System.out.print("返回order属于哪个用户：");
			System.out.println(order);
			return order;
			
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.OrderDao#getAll(boolean)
	 */
	@Override
	@SuppressWarnings("deprecation")
	public List<Order> getAll(boolean state) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "select * from orders where state=?";
			
			@SuppressWarnings("unchecked")
			List<Order> list = (List<Order>) runner.query(sql, state, new BeanListHandler(Order.class));
			for (Order order : list) {
				// 找出当前订单属于哪个用户
				sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
				User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.letseat.dao.impl.OrderDao#update(com.letseat.po.Order)
	 */
	@Override
	public void update(Order order) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.gDataSource());
			String sql = "update orders set state=? where id=?";
			Object params[] = { order.isState(), order.getId() };
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
