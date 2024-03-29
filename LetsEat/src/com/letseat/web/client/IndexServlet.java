package com.letseat.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letseat.po.Page;
import com.letseat.service.Impl.BusinessServiceImpl;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equalsIgnoreCase("getAll")) {
			getAll(request, response);
		} else if (method.equalsIgnoreCase("listFoodWithCategory")) {
			listBookWithCategory(request, response);
		}

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		List categorys = service.getAllCategory();
		request.setAttribute("categorys", categorys);

		String pagenum = request.getParameter("pagenum");
		Page page = service.getFoodPageData(pagenum);
		request.setAttribute("page", page);

		request.getRequestDispatcher("/client/body.jsp").forward(request, response);
	}

	public void listBookWithCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category_id = request.getParameter("category_id");
		String pagenum = request.getParameter("pagenum");
		BusinessServiceImpl service = new BusinessServiceImpl();
		Page page = service.getFoodPageData(pagenum, category_id);

		request.setAttribute("categorys", service.getAllCategory());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/body.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
