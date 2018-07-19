<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台首页</title>
</head>
<frameset rows="25%,*">
	<frame src="${pageContext.request.contextPath}/manager/head.jsp" name="head" name="head">
	<frameset cols="15%,*">
	<frame src="${pageContext.request.contextPath}/manager/left.jsp" name="left" name="left">
	<frame src="${pageContext.request.contextPath}/manager/body.jsp" name="body" name="body">
	</frameset>
</frameset>
</html>