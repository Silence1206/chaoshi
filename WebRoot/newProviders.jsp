<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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

		<title>My JSP 'MyJsp.jsp' starting page</title>

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
	${param["errorMessage"]}
	<%=request.getAttribute("errorMessage") %>
	${123}
		<form action="newProvider" method="post">
		<input type="text" name="userId">
		<br>
		<br>
		<input type="text" name="name">
		<br>
		<input type="text" name="address">
		<br>
		<input type="text" name="tel">
		<br>
		<input type="text" name="type">
		<br>
		<input type="submit" name="sub" value="tijiao">
		</form>
	</body>
</html>
