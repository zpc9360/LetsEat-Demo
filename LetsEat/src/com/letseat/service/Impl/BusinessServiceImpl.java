package com.letseat.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.letseat.dao.CategoryDao;
import com.letseat.dao.FoodDao;
import com.letseat.dao.OrderDao;
import com.letseat.dao.UserDao;
import com.letseat.po.Cart;
import com.letseat.po.CartItem;
import com.letseat.po.Category;
import com.letseat.po.Food;
import com.letseat.po.Order;
import com.letseat.po.OrderItem;
import com.letseat.po.Page;
import com.letseat.po.User;
import com.letseat.service.BusinessService;
import com.letseat.utils.DaoFactory;
import com.letseat.utils.WebUtils;

public class BusinessServiceImpl implements BusinessService {

	private CategoryDao dao = DaoFactory.getInstance().createDao("com.letseat.dao.impl.CategoryDaoImpl",
			CategoryDao.class);
	private FoodDao fdao = DaoFactory.getInstance().createDao("com.letseat.dao.impl.FoodDaoImpl", FoodDao.class);
	private UserDao udao = DaoFactory.getInstance().createDao("com.letseat.dao.impl.UserDaoImpl", UserDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao("com.letseat.dao.impl.OrderDaoImpl", OrderDao.class);
	
	/**添加分类**/
	public void addCategory(Category category) {
		dao.add(category);
	}

	/**查找分类**/
	public Category findCategory(String id) {
		return dao.find(id);
	}

	/**获取所有分类**/
	public List<Category> getAllCategory() {
		return dao.getAll();
	}

	/**添加食物种类**/
	public void addFood(Food food) {
		fdao.add(food);
	}

	/**查找食物信息**/
	public Food findFood(String foodid) {
		return fdao.find(foodid);

	}

	/**获取翻页数据**/
	public Page getFoodPageData(String pagenum) {

		int totalrecord = fdao.getTotalRecord();
		Page page = null;
		if (pagenum == null) {
			page = new Page(1, totalrecord);

		} else {
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List list = fdao.getPageData(page.getStartindex(), page.getPagesize());

		page.setList(list);
		return page;

	}

	public Page getFoodPageData(String pagenum, String category_id) {
		int totalrecord = fdao.getTotalRecord(category_id);
		
		Page page = null;
		if(pagenum==null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = fdao.getPageData(page.getStartindex(), page.getPagesize(),category_id);
		page.setList(list);
		return page;
	}

	public void buyfood(Cart cart, Food food) {
		cart.add(food);
	}
	//注册用户
	public void registerUser(User user) {
		udao.add(user);
		
	}
	//查找用户
	public User findUser(String id) {
		return udao.find(id);
		
	}
	//用户登录
	public User userLogin(String username,String password) {
		return udao.find(username, password);
		
	}
	
	public void createOrder(Cart cart,User user) {
		if(cart==null) {
			throw new RuntimeException("对不起！购物车为空！");
		}
		Order order = new Order();
		order.setId(WebUtils.makeID());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		for(Map.Entry<String,CartItem> me : cart.getMap().entrySet()) {
			//得到一个购物项就生成一个订单项
			CartItem citem = me.getValue();
			OrderItem oitem = new OrderItem();
			oitem.setFood(citem.getFood());
			oitem.setId(WebUtils.makeID());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			order.getOrderitems().add(oitem);
		}
		
		odao.add(order);
	}

	public List<Order> listOrder(String state) {
		return odao.getAll(Boolean.parseBoolean(state));
	}

	//列出订单明细
	public Order findOrder(String orderid) {
		
		return odao.find(orderid);
	}

	//把订单置为发货
	public void confirmOrder(String orderid) {
		Order order = odao.find(orderid);
		order.setState(true);
		odao.update(order);
	}


}