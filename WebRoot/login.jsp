<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="loginBean" class="com.serv.www.Login" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><%@ include file="head.txt" %>
    <title>��¼</title> 
	<meta http-equiv="pragma" content="no-cache">
  </head>
  <body bgcolor="pink">
    <div align="center">
    	<table border="2">
    		<tr>
    			<th>��¼</th>
    		</tr>
    		<form action="loginServlet" method="post" name="form">
    		<tr>
    			<td>�û����ƣ�<input type="text" name="user"/></td>
    		</tr>
   			<tr>
   				<td>�û����룺<input type="password" name="password"/></td>
   			</tr>
   			<tr>
   				<td align="center"><input type="submit" name="g" value="�ύ"/></td>
   			</tr>
    		</form>
    	</table>
    </div>
    <div align="center">
    	��¼������<br/>
    	<jsp:getProperty property="backNews" name="loginBean"/>
    	<br/>
    	�û����ƣ�
    	<br/>
    	<jsp:getProperty property="logname" name="loginBean"/>
    </div>
  </body>
</html>