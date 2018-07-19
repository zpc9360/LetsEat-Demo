<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
</head>
<body>
<h2>订单详情</h2>
	<table frame="border" border="1">
		<tr>
			<td>商品名称</td>
			<td>价格</td>
			<td>数量</td>
			<td>总应收款</td>

		</tr>
		<c:forEach var="orderitem" items="${order.orderitems}">
			<tr>
				<td>${orderitem.food.name}</td>
				<td>${orderitem.food.price}</td>
				<td>${orderitem.quantity}</td>
				<td>${orderitem.price}</td>

			</tr>

		</c:forEach>
		
		<tr>
			<td>订单总价</td>
			<td colspan="3">${order.price}元</td>
		

		</tr>
	</table>
<h2>收货人信息</h2>
	<table  frame="border" border="1">
		<tr>
			<td>用户</td>
			<td>电话</td>
			<td>地址</td>
		</tr>
		<tr>
			<td>${order.user.username}</td>
			<td>${order.user.phone}</td>
			<td>${order.user.address}</td>

		</tr>
			
	</table>
	<a href="${pageContext.request.contextPath}/ConfirmOrderServlet?orderid=${order.id}">确认发货</a>
</body>
</html>