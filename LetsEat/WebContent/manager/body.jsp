<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<div id="content" style="width: 840px">
			<div id="category" style="float:left"> 
				<c:forEach var="category" items="${categorys}">
					${category.name}
				</c:forEach>
			</div>
			<div id="foodandpage" style="float:left;margin-left:30px">
				
			</div>
			<div></div>
			<div></div>
	</div>

</body>
</html>