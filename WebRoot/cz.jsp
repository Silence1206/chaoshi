<%@ page pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="userBean" class="com.serv.www.Register" scope="request"/>
<jsp:useBean id="loginBean" class="com.serv.www.Login" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="head.txt" %>
    <title>��ֵ����</title>
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
    <div align="center">
    <form action="czServlet" method="post" name="form">
    <input type="radio" name="cz" value="1">�
	<input type="radio" name="cz" value="2">�ǻ
    </div>
    	<div>
    		<table align="center">
    			<tr>
	    			<td>�ֻ����룺</td>
	    			<td><input type="text" name="phone"/></td>
    			</tr>
    			<tr>
    				<td>��ֵ��</td>
    				<td><input type="text" name="money"/></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" name="g" value="�ύ"/></td>
    			</tr>
    		</table>
    	</div>
    </form>
    <div align="center">
    	<p>��ֵ������
    	<jsp:getProperty property="backNews" name="userBean"/>
    	<table border="3">
    		<tr>
    			<td>�û����ƣ�</td>
    			<td><jsp:getProperty property="phone" name="userBean"/></td>
    		</tr>
    		<tr>
    			<td>ʣ���</td>
    			<td><jsp:getProperty property="realname" name="userBean"/></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>