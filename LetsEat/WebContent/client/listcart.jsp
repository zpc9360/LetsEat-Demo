<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
</head>
<body>
	<h1>购物车</h1>
	<br />
	<table border="1">
		<tr>
			<td>菜品名称</td>
			<td>店家名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td colspan="3"> 操作 </td>
			
		</tr>
		<c:forEach var="me" items="${cart.map}">
			<tr>
				<td>${me.value.food.name}</td>
				<td>${me.value.food.store}</td>
				<td>${me.value.food.price}</td>
				<td>${me.value.quantity}</td>
				<td>${me.value.price}</td>
				<td><a href="#">删除</a></td>
				<td><a href="#">修改数量</a></td>
				<td><a href="#">修改收货地址</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">总价</td>
			<td colspan="3">${cart.price}元</td>
		</tr>
	</table>
	<a href ="${ pageContext.request.contextPath}/OrderServlet">下订单</a>
</body>
</html>