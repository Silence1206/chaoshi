<%@ page language="java" import="java.util.*" import = "java.sql.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <base href="<%=basePath%>"> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <%@ include file = "head.txt" %>
	 <title>主页</title>
  </head>
   <body>
    <center>
    	<h1><font Size=4 color=blue>
    	<br><br><br><br><br><br>
    	欢迎光临“超市进销存系统”
    	</font></h1>
    </center>
  </body>
</html>
