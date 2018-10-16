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

		<title>My JSP 'MyJsp1.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script language="JavaScript">
<!--
function check()
{ 
if(document.form2.userId.value.length>6){
window.alert("供应商编号不能超过6位！");
    document.form2.userId.focus();
    return false;
}
   if(document.form2.userId.value=="")
     {
    window.alert("供应商编号！");
    document.form2.userId.focus();
    return false;
    }
     if(document.form2.name.value.length>20){
       window.alert("供应商名称不能超过20！");
         document.form2.name.focus();
    return false
     }
    if(document.form2.name.value=="")
     {
    window.alert("供应商名称！");
    document.form2.name.focus();
    return false;
    }
      if(document.form2.tel.value.length>20){
         window.alert("联系电话不能超过20位");
    document.form2.tel.focus();
    return false;
      }
    if(document.form2.tel.value=="")
     {
    window.alert("联系电话！");
    document.form2.tel.focus();
    return false;
    }
    if(document.form2.address.value.length>50){
      window.alert("供应商地址不能超过50位！");
    document.form2.address.focus();
    return false;
    }
     if(document.form2.address.value=="")
     {
    window.alert("供应商地址！");
    document.form2.address.focus();
    return false;
    }
     if(document.form2.type.value.length>20){
       window.alert("供应商类别不能超过20位！");
    document.form2.type.focus();
    return false;
     }
      if(document.form2.type.value=="")
     {
    window.alert("供应商类别！");
    document.form2.type.focus();
    return false;
    }
    
    return true;

}
function check1(){
if(document.form1.value.value=="")
     {
    window.alert("请输入查询内容！");
    document.form1.value.focus();
    return false;
    }
}
function error(){
window.alert("用户已经存在！");
}
//-->
</script>
	</head>
	
	
				<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>

	<body bgcolor="#666666">
		<div align="center">
			<form action="selectPro" method="post" name="form1">
				<label>
					输入要查询的条件
					<select name="type">
						<option value="pro_Id">
							供应商编号
						<option value="pro_Name">
							供应商名称
						<option value="pro_Tel">
							联系电话
						<option value="pro_Address">
							供应商地址
						<option value="cargo_Type">
							供应商品类别
						<option value="pro_Date">
							合作时间
					</select>
				</label>
				<select name="comp">
					<option value="=" selected="selected">
						精确查找
					<option value="like">
						模糊查找
				</select>
				<input type="text" name="value">
				<input type="submit" name="sub" value="提交" onclick="return check1()">
				<input type="reset" name="res" value="取消">
			</form>
		</div>
		<div>
			<div align="left">
				商家信息
			</div>
			<table border="1" align="left">
				<tr>
					<td>
						供应商编号
					</td>
					<td>
						供应商名称
					</td>
					<td>
						联系电话
					</td>
					<td>
						供应商地址
					</td>
					<td>
						供应商品类别
					</td>
					<td>
						合作时间
					</td>
					<td align="center">
						操作
					</td>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>
							${list.pro_Id }
						</td>
						<td>
							${list.pro_Name }
						</td>
						<td>
							${list.pro_Tel }
						</td>
						<td>
							${list.pro_Address }
						</td>
						<td>
							${list.cargo_Type}
						</td>
						<td>
							${list.pro_Date }
						</td>
						<td>
							<a href="editPro?id=${list.pro_Id}">编辑</a>
							<a href="deletePro?id=${list.pro_Id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>

			<form action="newProvider" method="post" name="form2">

				<table border="1" align="right">
					<tr>
						<td>
							供应商编号
						</td>
						<td>
							<input type="text" name="userId">
						</td>
					</tr>
					<tr>
						<td>
							供应商名称
						</td>
						<td>
							<input type="text" name="name">
						</td>
					</tr>
					<tr>
						<td>
							联系电话
						</td>
						<td>
							<input type="text" name="tel">
						</td>
					</tr>
					<tr>
						<td>
							供应商地址
						</td>
						<td>
							<input type="text" name="address">
						</td>
					</tr>
					<tr>
						<td>
							供应商类别
						</td>
						<td>
							<input type="text" name="type">
						</td>
					</tr>
					<tr>
						<td>
							操作
						</td>
						<td>
							<input type="submit" name="sub" value="添加" onclick="return check()">
							<input type="reset" name="res" value="取消">

						</td>
					</tr>
				</table>
			</form>
			<label>
<c:if test="${errorMessage!=null}">
<script language="JavaScript">
error();
</script>

</c:if>
		</label>
		</div>
	</body>
</html>
