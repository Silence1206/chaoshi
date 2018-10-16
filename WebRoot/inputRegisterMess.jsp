<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="userBean" class="com.serv.www.Register" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="head.txt" %>
    <title>注册界面</title>
	<meta http-equiv="pragma" content="no-cache">
  </head>
  <body bgcolor="pink">
    <form action="registerServlet" method="post" name="form">
    	<div>
    		<table align="center">
    			<tr>
    				<td>用户名称：</td>
    				<td><input type="text" name="user"/></td>
    			</tr>
    			<tr>
    				<td>用户密码：</td>
    				<td><input type="password" name="password"/></td>
    			</tr>
    			<tr>
    				<td>重复密码：</td>
    				<td><input type="password" name="again_password"/></td>
    			</tr>
    			<tr>
    				<td>用户地址：</td>
    				<td><input type="text" name="address"/></td>
    			</tr>
    			<tr>
    				<td>手机号码：</td>
    				<td><input type="text" name="phone"/></td>
    			</tr>
    			<tr>
    				<td>真实姓名：</td>
    				<td><input type="text" name="realname"/></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" name="g" value="提交"/></td>
    			</tr>
    		</table>
    	</div>
    </form>
    <div align="center">
    	<p>注册反馈：
    	<jsp:getProperty property="backNews" name="userBean"/>
    	<table border="3">
    		<tr>
    			<td>用户名称：</td>
    			<td><jsp:getProperty property="user" name="userBean"/></td>
    		</tr>
    		<tr>
    			<td>用户地址：</td>
    			<td><jsp:getProperty property="address" name="userBean"/></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>