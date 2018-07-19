
package com.letseat.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.Cart;
import com.letseat.po.Food;
import com.letseat.service.Impl.BusinessServiceImpl;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String foodid = request.getParameter("foodid");
			BusinessServiceImpl service = new BusinessServiceImpl();
			Food book = service.findFood(foodid);
			
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart==null){
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			service.buyfood(cart,book);
			request.getRequestDispatcher("/client/listcart.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "购买失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
