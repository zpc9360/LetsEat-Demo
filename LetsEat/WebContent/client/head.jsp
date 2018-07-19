<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页头</title>
</head>
<body>
	<h1>饭来啦</h1><br/>
	<a href="${pageContext.request.contextPath}/IndexServlet?method=getall" target="body">首页</a><br/><br/>
	<a href="${pageContext.request.contextPath}/client/listcart.jsp" target="body">查看购物车</a>
	<a href="${pageContext.request.contextPath}/OrderServlet" target="body">查看订单</a><br/>
	<a href="${pageContext.request.contextPath}/manager.jsp"  target="body">后台管理（不用登陆！不要权限！）</a>
	<div>
	<c:if test="${user==null}">
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		用户名（可以用的）：<input type="text" name="username">
		密码：<input type="password" name="password">
		<input type="submit" value="登录">
		可以用的：<input type="button" value="注册" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath}/client/register.jsp'">
	</form>
	</c:if>
	<c:if test="${user!=null}">
		欢迎您：${user.username} <a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
	</c:if>
	</div>
</body>
</html>