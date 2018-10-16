<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editMana.jsp' starting page</title>
    
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
  <form name="form1" action="manaUpdate" method="post">
   <table border="1" name="table1" align="center">
   <c:forEach var="list" items="${list}">
 <tr><td>用户名</td><td>${list.mana_name}</td></tr>
 <tr><td>密码</td><td><input type="text" name="pwd" value="${list.mana_pwd}"></td></tr> 
	<tr><td>性别</td><td><select name="sex">
	                    <option >${list.mana_sex}</option>
						<option value="男">
							男
						<option value="女">
							女
						
					</select></td></tr>
   <tr><td>年龄</td><td><input type="text" name="age" value="${list.mana_age}"></td></tr>
    <tr><td>mana_dep</td><td><input type="text" name="mana_dep" value="${list.mana_dep}"></td></tr>
     <tr><td>电话号码</td><td><input type="text" name="tel" value="${list.mana_tel}"></td></tr>
      <tr><td>地址</td><td><input type="text" name="address" value="${list.mana_address}"></td></tr>
      </c:forEach>
     <tr><td>操作</td><td align="center"><input type="submit" name="sub" value="确定" >
     <input type="reset" name="res" value="取消"></td></tr>
   </table>
   </form>
  </body>
</html>
