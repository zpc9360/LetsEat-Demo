package com.letseat.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.Order;
import com.letseat.service.Impl.BusinessServiceImpl;

public class ListOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = request.getParameter("state");
		BusinessServiceImpl service= new BusinessServiceImpl();
		List<Order> orders = service.listOrder(state);	
		request.setAttribute("orders",orders);
		request.getRequestDispatcher("/manager/listorder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

