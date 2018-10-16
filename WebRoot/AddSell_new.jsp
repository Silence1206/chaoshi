<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>

		<title>My JSP 'AddSell_new.jsp' starting page</title>
	</head>
	<center>
		<br>
		<h2>
			新增上架商品
		</h2>
		<br>
		<br>
		<hr>
				<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
		<body>

			<form action="AddSell_new" method="post">
				<table>
					<tr>
						<td>
							商品编号：
						</td>
						<td>
							${id }
						</td>
					</tr>
					<tr>
					<td>商品名称：</td>
					<td><input type="text" name="name" ></td>
					</tr>
					<td>商品类型：</td>
					<td><input type="text" name="type"></td>
				</tr>
					<tr>
						<td>
							上架数量：
						</td>
						<td>
							<input type="text" name="addNum" value="0">
						</td>
					</tr>
					<tr>
						<td>
							价格:
						</td>
						<td>
							<input type="text" name="price" value="0.0">
						</td>
					</tr>
					<tr>
						<td>
							库存数量:
						</td>
						<td>
							${num }
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="提交">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消">
						</td>
					</tr>
				</table>
				<input type="hidden" name="id" value="${param.id }">
				<input type="hidden" name="storageNum" value="<%=request.getAttribute("num") %>">
			</form>


		</body>
	</center>
</html>
