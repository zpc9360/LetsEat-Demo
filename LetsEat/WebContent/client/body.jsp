<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'body.jsp' starting page</title>
  </head>
  
  <body >
    
    <div>
    	
    	<div id="category" style="float: left;width: 200px;text-align: left;height: 300px;margin-left: 150px">
    		分类列表：
    		<ul>
    		<c:forEach var="category" items="${categorys}">
    			<li>
    			<a href="${pageContext.request.contextPath }/IndexServlet?method=listFoodWithCategory&category_id=${category.id }">${category.name }</a>
    			</li>
    		</c:forEach>
    		</ul>
    	</div>
    	
    	<div id="fookandpage" style="float: left;margin-left: 50px">
    	
    		<div id="foods">
    			<c:forEach var="food" items="${page.list}">
    				<div id="food">
    					<div id="image" style="float: left">
    						<img src="${pageContext.request.contextPath }/images/${food.image }" width="83px" height="118px">
    					</div>
    					
    					<div id="foodinfo" style="float:left;text-align: left;">
    						<ul>
    							<li>${food.name }</li>
    							<li>${food.store }</li>
    							<li>${food.price }元</li>
    							<li>${food.description }</li>
    							<li>
    								<a href="${pageContext.request.contextPath }/BuyServlet?foodid=${food.id}">购买</a>
    							</li>
    						</ul>
    					</div>
    					<div style="clear: both"></div>
    					<br/>
    				</div>
    			</c:forEach>
    		</div>
    	
    		<div style="clear: both"></div>
    		<div id="page">
    			当前第[${page.pagenum }]页 &nbsp; &nbsp;
    
			    <c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
			    	[<a href="${pageContext.request.contextPath }/IndexServlet?pagenum=${pagenum }&category_id=${param.category_id }&method=${param.method }">${pagenum }</a>]
			    </c:forEach>
			    &nbsp; &nbsp;
			    总共[${page.totalpage }]页，总[${page.totalrecord }]记录
    		</div>
    	
    	</div>
    </div>
    
  </body>
</html>