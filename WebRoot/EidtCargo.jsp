<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>商品编辑</title>
	</head>


		<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
	<body>
		<center>
			<br />
			<h1>
				超市管理系统————————商品列表
			</h1>

			<br />
			<br />
			<hr>
			<br />
			<form action="FinishCargoInf" method="post">
				<table>
					<c:forEach var="cargo" items="${list}">
						<tr>
							<td>
								商品编号:
							</td>
							<td>
								${cargo.cargo_id }
							</td>
						</tr>
						<tr>
							<td>
								商品名：
							</td>
							<td>
								<input type="text" name="cargoName" value="${cargo.cargo_name}">
							</td>
						</tr>
						<tr>
							<td>
								商品类别：
							</td>
							<td>
								<input type="text" name="cargoType" value="${cargo.cargo_type }">
							</td>
						</tr>
						<tr>
							<td>
								在架数量：
							</td>
							<td>
								<input type="text" name="sellNum" value="${cargo.sell_num }">
							</td>
						</tr>
						<tr>
							<td>
								商品单价：
							</td>
							<td>
								<input type="text" name="sellPrice" value="${cargo.sell_price }">
								￥
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="修改">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="取消">
							</td>
						</tr>
						<input type="hidden" name="id" value="${cargo.cargo_id }">
					</c:forEach>
				</table>
			</form>
		</center>
	</body>
</html>
