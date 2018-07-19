package com.letseat.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.Category;
import com.letseat.service.Impl.BusinessServiceImpl;
import com.letseat.utils.WebUtils;

public class CategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		if (method.equals("add")) {
			add(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("update")) {
			update(request, response);
		} else if (method.equals("find")) {
			find(request, response);
		} else if (method.equals("listall")) {
			listall(request, response);
		} else {
			request.setAttribute("message", "不支持此类操作");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void listall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			BusinessServiceImpl service = new BusinessServiceImpl();
			List<Category> categorys = service.getAllCategory();
			request.setAttribute("categorys", categorys);
			request.getRequestDispatcher("manager/listcategory.jsp").forward(request, response);
	
	}


	private void find(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Category category = new Category();
			category.setName(name);
			category.setDescription(description);
			category.setId(WebUtils.makeID());

			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addCategory(category);
			request.setAttribute("message", "添加成功！！");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败!!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
