<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有美食</title>
</head>
<body style="text-align: center;">
	<br />
	<table frame="border" width="60%">
		<tr>
			<td>菜品名称：</td>
			<td>商家名称：</td>
			<td>价格：</td> 
			<td>图片：</td>
			<td>描述：</td>
			<td>操作：</td>
			
		</tr>

		<c:forEach var="food" items="${page.list}">
			<tr>

				<td>${food.name}</td>
				<td>${food.store}</td>
				<td>${food.price}</td>
				<td><a href="${pageContext.request.contextPath}/images/${food.image}">查看图片</a></td>
				<td>${food.description}</td>

				<td><a href="">删除</a><a href="">修改</a></td>
			</tr>
		</c:forEach>

	</table>
 
    当前第[${page.pagenum }]页 &nbsp; &nbsp;
    
    <c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
    	[<a href="${pageContext.request.contextPath }/FoodServlet?method=list&pagenum=${pagenum }">${pagenum }</a>]
    </c:forEach>
    &nbsp; &nbsp;
    总共[${page.totalpage }]页，总[${page.totalrecord }]纪录

</body>
</html>