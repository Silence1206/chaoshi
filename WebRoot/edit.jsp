<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'edit.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	
			<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>

	<body>

	<form name="form1" action="update?id=${list[0].pro_Id }" method="post">
		<table border="1" align="center">
			<c:forEach var="list" items="${list}">
			
				<tr bgcolor="green">
					<td>
						供应商编号
						</td>
						<td >
						<input disabled="disabled" type="text" name="id"  value="${list.pro_Id}">
					
					</td>
				</tr>
				
				<tr>
					<td>
						供应商名称
						</td>
						<td>
						<input type="text" name="name" value="${list.pro_Name}">
					</td>
				</tr>
				<tr>
					<td>
						联系电话
						</td>
						<td>
						<input type="text"  name="tel" value="${list.pro_Tel} ">
					</td>
				</tr>
				<tr>
					<td>
						供应商地址
						</td>
						<td>
						<input type="text" name="address" value="${list.pro_Address}">
					</td>
				</tr>
				<tr>
					<td>
						供应商品类别
						</td>
						<td>
						<input type="text" name="type" value="${list.cargo_Type}">
					</td>
				</tr>
				<tr>
					<td>
						合作时间
						</td>
						<td>
						<input type="text" name="date" value="${list.pro_Date}">
					</td>
				</tr>
<tr>
<td>
操作
</td>
<td><input type="submit" name="sub" value="修改">
<input type="reset" name="res" value="取消">


			</c:forEach>
		</table>
		</form>
	</body>
</html>
