package com.letseat.web.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.letseat.po.Food;
import com.letseat.po.Page;
import com.letseat.service.Impl.BusinessServiceImpl;
import com.letseat.utils.WebUtils;

@SuppressWarnings("serial")
public class FoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if(method.equals("addUI")){
			addUI(request,response);
		}
		if(method.equalsIgnoreCase("add")){
			add(request,response);  //派发请求
		}
		if(method.equalsIgnoreCase("list")){
			list(request,response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagenum = request.getParameter("pagenum");
		BusinessServiceImpl service = new BusinessServiceImpl();
		Page page = service.getFoodPageData(pagenum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listfood.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Food food = doupload(request);
			BusinessServiceImpl service = new BusinessServiceImpl();
			food.setId(WebUtils.makeID());
			service.addFood(food);
			request.setAttribute("message", "添加成功！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private Food doupload(HttpServletRequest request){
		
		//把上传的图片保存到images目录中，并把request中的请求参数封装到Food中
		Food food = new Food();
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(food, name, value);
				}else{
					String filename = item.getName();
					String savefilename = makeFileName(filename);//得到保存在硬盘的文件名
					String savepath = this.getServletContext().getRealPath("/images");
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
					int len = 0;
					byte buffer[] = new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
					food.setImage(savefilename);
				}
			}
			return food;
		}catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
	
	public String makeFileName(String filename){
		String ext = filename.substring(filename.lastIndexOf("//.")+1);
		return UUID.randomUUID().toString() + ext;
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		List categorys = service.getAllCategory();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/manager/addfood.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

