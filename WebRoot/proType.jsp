<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
  <head>
    
    <title>My JSP 'proType.jsp' starting page</title>

  </head>
  
  			<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
  
  <body>
<table border="1" align="center">
<tr><td align="center">分类</td><td align="center">命令</td></tr>
  <c:forEach var="list" items="${list}">
			<tr><td>${list.cargo_Type }</td>
				<td>
						<a href="proTypeView?type=${list.cargo_Type}" ><font color="green">显示该类供应商</font></a>
						<a href="deleteProType?id=${list.pro_Id}"><font color="green">删除 </font></a>
			</td></tr>
			</c:forEach>
			</table>
  </body>
</html>
