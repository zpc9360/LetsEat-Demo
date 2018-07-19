<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有分类</title>
</head>
<body style="text-align: center;">
	<br/>
	<table frame="border" width="60%">
		<tr>
			<td>分类名称</td>
			<td>分类操作</td>
			<td>操作</td>
		</tr>

		<c:forEach var="c" items="${categorys}">
			<tr>
				<td>${c.name }</td>
				<td>${c.description}</td>
				<td><a href="">删除</a><a href="">修改</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>