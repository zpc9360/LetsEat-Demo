<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示订单</title>
</head>
<body>
	<h1>订单列表</h1>
	<br />
	<table border="1">
		<tr>
			<td>订单号</td>
			<td>订单时间</td>
			<td>购买用户</td>	
			<td>订单总价</td>
			<td>订单状态</td>
			<td colspan="3"> 操作 </td>
			
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.id}</td>
				<td>${order.ordertime}</td>
				<td>${order.user.username}</td>
				<td>${order.price}</td>
				<td>${order.state==true?'已发货':'未发货'}</td>
				<td><a href="${pageContext.request.contextPath}/OrderDetailServlet?orderid=${order.id}">查看明细</a></td>
				<td><a href="#">删除订单</a></td>
				<td><a href="#">修改数量</a></td>
				<td><a href="#">修改收货地址</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>