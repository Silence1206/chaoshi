<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
  <head>
    <title>商品类型</title>
  </head>
  
  		<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
  
  <body>
   <center>
		<br/>
			<h1>
			超市管理系统————————商品类型列表
			</h1>
		</center>
		<br/>
		<br/>
		<hr>
		<br/> 
		<table align="center">
		<tr>
		<th>
		商品种类
		</th>
		</tr>
		<c:forEach var="type" items="${array}">
		<tr>
		<td>
		${type.cargo_type}
		</td>
		</tr>
		</c:forEach>
		</table>
  </body>
</html>
