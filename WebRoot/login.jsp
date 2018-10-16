<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="loginBean" class="com.serv.www.Login" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><%@ include file="head.txt" %>
    <title>登录</title> 
	<meta http-equiv="pragma" content="no-cache">
  </head>
  <body bgcolor="pink">
    <div align="center">
    	<table border="2">
    		<tr>
    			<th>登录</th>
    		</tr>
    		<form action="loginServlet" method="post" name="form">
    		<tr>
    			<td>用户名称：<input type="text" name="user"/></td>
    		</tr>
   			<tr>
   				<td>用户密码：<input type="password" name="password"/></td>
   			</tr>
   			<tr>
   				<td align="center"><input type="submit" name="g" value="提交"/></td>
   			</tr>
    		</form>
    	</table>
    </div>
    <div align="center">
    	登录反馈：<br/>
    	<jsp:getProperty property="backNews" name="loginBean"/>
    	<br/>
    	用户名称：
    	<br/>
    	<jsp:getProperty property="logname" name="loginBean"/>
    </div>
  </body>
</html>