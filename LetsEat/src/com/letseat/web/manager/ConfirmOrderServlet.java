package com.letseat.web.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.service.Impl.BusinessServiceImpl;

public class ConfirmOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
		String orderid = request.getParameter("orderid");
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.confirmOrder(orderid);
			request.setAttribute("message", "订单已发送，待用户收货！！");
		}catch(Exception e) {
			request.setAttribute("message", "发货失败！！");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

