<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<%@ page import="com.serv.www.Login" %>
<%@ page import="java.sql.*" %>
<jsp:useBean id="loginBean" class="com.serv.www.Login" scope="session"/>
<jsp:useBean id="userBean" class="com.serv.www.Stock" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="head.txt" %>
    <title>���۽���</title>  
	<meta http-equiv="pragma" content="no-cache">
  </head>
	  <body bgcolor=cyan>
	  <br><br>
	  <%	if(loginBean==null)
    			response.sendRedirect("login.jsp");
    		else{
    			boolean b=loginBean.getLogname()==null || loginBean.getLogname().length()==0;
    			if(b)
    				response.sendRedirect("login.jsp");
    		}
 		 %>
	  <form action="saleServlet" method="post" name="form">
	  <table align="center">
	  	<tr>
	  		<td>�������ƣ�</td>
	  		<td><input type="text" name=shopname></td>
	  	</tr>
	  	<tr>
	  		<td>���۵��ۣ�</td>
	  		<td><input type="text" name=saleprice></td>
	  	</tr>
	  	<tr>
	  		<td>����������</td>
	  		<td><input type="text" name=salenum></td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" align="center"><input type="submit" name="g" value="ȷ��"/></td>
		</tr>
	  </table>
	  </form>
	  <div align="center">
	    	<p>���۷�����
	    	<jsp:getProperty property="backNews" name="userBean"/>
	    	<table border="3">
	    	<tr>
		  		<td>�����ܶ</td>
		  		<td><jsp:getProperty property="total" name="userBean"/></td>
		  	</tr>
		  	<tr>
		  		<td>��������</td>
		  		<td><jsp:getProperty property="lirun" name="userBean"/></td>
		  	</tr> 
		  	<tr>
		  		<td>ʣ��������</td>
		  		<td><jsp:getProperty property="last" name="userBean"/></td>
		  	</tr>
	    	</table>
	    </div>
	  </body>
</html>
