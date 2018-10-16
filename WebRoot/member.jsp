<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="userBean" class="com.serv.www.Register" scope="request"/>
<jsp:useBean id="loginBean" class="com.serv.www.Login" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="head.txt" %>
    <title>会员注册</title>
	<meta http-equiv="pragma" content="no-cache">
  </head>
  <body bgcolor="pink">
    	<%	if(loginBean==null)
    			response.sendRedirect("login.jsp");
    		else{
    			boolean b=loginBean.getLogname()==null || loginBean.getLogname().length()==0;
    			if(b)
    				response.sendRedirect("login.jsp");
    		}
 		 %>
   		 <form action="mmServlet" method="post" name="form">
    		<table align="center">
    			<tr>
	    			<td>手机号码：</td>
	    			<td><input type="text" name="phone"/></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" name="g" value="查询余额"/></td>
    			</tr>
    		</table>
    	</form>
	    <div align="center">
	    <br><br><br>
	    	查询反馈：<jsp:getProperty property="backNews" name="userBean"/>
	    	<table border="3">
	    		<tr>
	    			<td>用户名称：</td>
	    			<td><jsp:getProperty property="user" name="userBean"/></td>
	    		</tr>
	    		<tr>
	    			<td>剩余金额：</td>
	    			<td><jsp:getProperty property="money" name="userBean"/></td>
	    		</tr>
	    	</table>
	    </div>
  </body>
</html>