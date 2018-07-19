package com.letseat.web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.Order;
import com.letseat.service.Impl.BusinessServiceImpl;

public class OrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orderid = request.getParameter("orderid");
		
		System.out.print("订单的id号为：");
		System.out.println(orderid);
		BusinessServiceImpl service = new BusinessServiceImpl();
		@SuppressWarnings("unused")
		Order order = service.findOrder(orderid);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/manager/orderdetail.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

