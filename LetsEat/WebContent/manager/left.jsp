
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台左侧导航</title>
</head>
<body>
	<a href="#" target="body">分类管理</a><br/><br/>
	<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="body">添加分类</a><br/><br/>
	<a href="${pageContext.request.contextPath }/CategoryServlet?method=listall" target="body">查看分类</a>
	
	<br/><br/>
	
	<a href="#" target="body">菜品管理</a><br/><br/>
	<a href="${pageContext.request.contextPath }/FoodServlet?method=addUI" target="body">菜品添加</a><br/><br/>
	<a href="${pageContext.request.contextPath }/FoodServlet?method=list" target="body">所有美食</a><br/><br/>
	<a href="#" target="body">订单管理</a><br/><br/>
	<a href="${pageContext.request.contextPath }/ListOrderServlet?state=false" target="body">待处理订单</a><br/><br/>
	<a href="${pageContext.request.contextPath }/ListOrderServlet?state=true" target="body">已发货订单</a><br/><br/>

</body>

</html>