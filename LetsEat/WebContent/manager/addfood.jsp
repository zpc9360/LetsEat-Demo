<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品页面</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/FoodServlet?method=add" method="post" enctype="multipart/form-data">
		<table frame="border" width="50%">
			<tr>
				<td>菜式名称：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>饭馆名称：</td>
				<td><input type="text" name="store"></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>图片：</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>详情描述：</td>
				<td><textarea rows="5" cols="40" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td>所属分类：</td>
				<td><select name="category_id">
						<c:forEach var="c" items="${categorys}">
							<option value="${c.id }">${c.name }</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>
					<input type="reset" value="重置">
				
				</td>
				<td>
					<input type="submit" value="添加">
				
				</td>
			</tr>
		</table>
	</form>
</body>

</html>