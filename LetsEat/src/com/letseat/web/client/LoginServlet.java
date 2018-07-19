package com.letseat.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.User;
import com.letseat.service.Impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		 BusinessServiceImpl service = new BusinessServiceImpl();
		 User user =  service.userLogin(username, password);
		 if(user==null) {
			 request.setAttribute("message","用户名或密码错误");
			 request.getRequestDispatcher("/message.jsp").forward(request, response);
			 return;
		 }else {
			 request.getSession().setAttribute("user",user);
			 request.getRequestDispatcher("/client/head.jsp").forward(request, response);
		 }
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

