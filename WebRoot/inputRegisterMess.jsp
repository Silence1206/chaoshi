<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="userBean" class="com.serv.www.Register" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="head.txt" %>
    <title>ע�����</title>
	<meta http-equiv="pragma" content="no-cache">
  </head>
  <body bgcolor="pink">
    <form action="registerServlet" method="post" name="form">
    	<div>
    		<table align="center">
    			<tr>
    				<td>�û����ƣ�</td>
    				<td><input type="text" name="user"/></td>
    			</tr>
    			<tr>
    				<td>�û����룺</td>
    				<td><input type="password" name="password"/></td>
    			</tr>
    			<tr>
    				<td>�ظ����룺</td>
    				<td><input type="password" name="again_password"/></td>
    			</tr>
    			<tr>
    				<td>�û���ַ��</td>
    				<td><input type="text" name="address"/></td>
    			</tr>
    			<tr>
    				<td>�ֻ����룺</td>
    				<td><input type="text" name="phone"/></td>
    			</tr>
    			<tr>
    				<td>��ʵ������</td>
    				<td><input type="text" name="realname"/></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" name="g" value="�ύ"/></td>
    			</tr>
    		</table>
    	</div>
    </form>
    <div align="center">
    	<p>ע�ᷴ����
    	<jsp:getProperty property="backNews" name="userBean"/>
    	<table border="3">
    		<tr>
    			<td>�û����ƣ�</td>
    			<td><jsp:getProperty property="user" name="userBean"/></td>
    		</tr>
    		<tr>
    			<td>�û���ַ��</td>
    			<td><jsp:getProperty property="address" name="userBean"/></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>