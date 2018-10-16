<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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

		<title>My JSP 'manaView.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
<script language="JavaScript">
<!--
function checkAdd()
{ 
   if(document.getElementById("form1").name.value.length>20){
window.alert("用户名不能超过20位");
    document.getElementById("form1").name.focus();
    return false;
    }
   if(document.getElementById("form1").name.value=="")
     {
    window.alert("用户名不能为空！");
    document.getElementById("form1").name.focus();
    return false;
    }
   if(document.getElementById("form1").pwd.value.length>10){
window.alert("密码不能超过10位");
    document.getElementById("form1").pwd.focus();
    return false;
    }
   if(document.getElementById("form1").pwd.value=="")
     {
    window.alert("密码不能为空！");
    document.getElementById("form1").pwd.focus();
    return false;
    }
  if(document.getElementById("form1").age.value.length>3){
window.alert("年龄不能超过3位");
    document.getElementById("form1").age.focus();
    return false;
    }
   if(document.getElementById("form1").age.value=="")
     {
    window.alert("年龄不能为空！");
    document.getElementById("form1").age.focus();
    return false;
    }
      if(document.getElementById("form1").Mana_DepID.value.length>20){
window.alert("Mana_DepID不能超过20位");
    document.getElementById("form1").Mana_DepID.focus();
    return false;
    }
   if(document.getElementById("form1").Mana_DepID.value=="")
     {
    window.alert("Mana_DepID不能为空！");
    document.getElementById("form1").Mana_DepID.focus();
    return false;
    }
       if(document.getElementById("form1").tel.value.length>15){
window.alert("电话号码不能超过15位");
    document.getElementById("form1").tel.focus();
    return false;
    }
   if(document.getElementById("form1").tel.value=="")
     {
    window.alert("电话号码不能为空！");
    document.getElementById("form1").tel.focus();
    return false;
    }
        if(document.getElementById("form1").address.value.length>30){
window.alert("地址不能超过30位");
    document.getElementById("form1").address.focus();
    return false;
    }
   if(document.getElementById("form1").address.value=="")
     {
    window.alert("地址不能为空！");
    document.getElementById("form1").address.focus();
    return false;
    }
 

  
    return true;

}
function check()
{ 
document.getElementById("form1").style.display="block"

    document.getElementById("btn").style.display="none"
}
 
//-->
</script>
	<body>
	
	<c:remove var="mana_name" scope="session"/>
	<c:if test="${newManaErro!=null}">
			
			<script language="JavaScript">
   window.alert("已经存在该用户！");
  </script>
	</c:if>
		<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
		<c:if test="${error!=null}">
			<script language="JavaScript">
   window.alert("对不起！不能删除自己的信息！只能对自己信息修改！");
  </script>
		</c:if>
		<c:choose>
			<c:when test="${popedom==1}">
				<table border="1" align="center">
					<tr>
						<td align="center">
							用户名
						</td>
						<td align="center">
							密码
						</td>
						<td align="center">
							性别
						</td>
						<td>
							年纪
						</td>
						<td>
							Mana_DepID
						</td>
						<td>
							电话号码
						</td>
						<td>
							住址
						</td>
						<td>
							命令
						</td>
					</tr>

					<c:forEach var="list" items="${list}">

						<tr>
						<c:if test="${list.mana_name==manager}">
							<td bgcolor="green">
								${list.mana_name}
							</td>
							<td>
								${list.mana_pwd}
							</td>
							<td>
								${list.mana_sex}
							</td>
							<td>
								${list.mana_age}
							</td>
							<td>
								${list.mana_dep}
							</td>
							<td>
								${list.mana_tel}
							</td>
							<td>
								${list.mana_address}
							</td>
							<td>
							
								<a href="editMana">修改个人资料</a>
							</td>
						</c:if>
						<c:if test="${list.mana_name!=manager}">
							<td>
								${list.mana_name}

							</td>
							<td>
								${list.mana_pwd}
							</td>
							<td>
								${list.mana_sex}
							</td>
							<td>
								${list.mana_age}
							</td>
							<td>
								${list.mana_dep}
							</td>
							<td>
								${list.mana_tel}
							</td>
							<td>
								${list.mana_address}
							</td>
							<td>
								<a href="deleteMana?mana_name=${list.mana_name}">删除</a>
								<a href="editMana?mana_name=${list.mana_name}">编辑</a>
							</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div align="right"><input type="button" id="btn" align="bottom" value="添加新用户" onclick="check()"></div>
				<form id="form1" action="newMana" method="post" style="display:none">
					<table align="right" >
					<tr><td>用户名</td><td><input type="text" name="name"></td></tr>
					<tr><td>密码</td><td><input type="text" name="pwd"></td></tr>
					<tr><td>性别</td><td><select name="sex">
						<option value="男" selected="selected">
							男
						<option value="女">
							女
						
					</select></td></tr>
					<tr><td>年纪</td><td><input type="text" name="age"></td></tr>
					<tr><td>Mana_DepID</td><td><input type="text" name="Mana_DepID"></td></tr>
					<tr><td>电话号码</td><td><input type="text" name="tel"></td></tr>
					<tr><td>住址</td><td><input type="text" name="address"></td></tr>
					<tr><td>操作</td>
					<td><input type="submit" name="sub" value="添加" onclick="return checkAdd()">
					<input type="reset" name="res" value="取消"></td></tr>
											
					
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<table border="1" align="center">
					<tr>
						<td align="center">
							用户名
						</td>
						<td align="center">
							性别
						</td>
						<td>
							年纪
						</td>
						<td>
							Mana_DepID
						</td>
						<td>
							电话号码
						</td>
						<td>
							住址
						</td>
						<td>操作</td>
					</tr>
					<c:forEach var="list" items="${list}">
						
						<tr>
						<c:if test="${list.mana_name==manager}"><td bgcolor="green">
								${list.mana_name}
								<input type="hidden" name="mana_name" value="${list.mana_name}">
							</td>
							
							<td>
								${list.mana_sex}
							</td>
							<td>
								${list.mana_age}
							</td>
							<td>
								${list.mana_dep}
							</td>
							<td>
								${list.mana_tel}
							</td>
							<td>
								${list.mana_address}
							</td>
							<td><a href="editMana">修改资料</a></td>
							</c:if>
						<c:if test="${list.mana_name!=manager}">
					
							<td>
								${list.mana_name}
								
							</td>
							<td>
								${list.mana_sex}
							</td>
							<td>
								${list.mana_age}
							</td>
							<td>
								${list.mana_dep}
							</td>
							<td>
								${list.mana_tel}
							</td>
							<td>
								${list.mana_address}
							</td>
							<td>无</td>
						</c:if>

						</tr>
						
					</c:forEach>
					
				</table>
			
			</c:otherwise>
			
		</c:choose>
	
		</form>
	
	</body>
	
</html>

