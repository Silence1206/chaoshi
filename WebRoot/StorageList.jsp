<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>StorageList table</title>
	</head>

				<c:if test="${manager==null}">
  <c:set value="123" var="login" scope="session" />
			<c:redirect url="login.jsp"></c:redirect>
		</c:if>
	<body>
		<center>
			<br />
			<h1>
				超市管理系统————————库存列表
			</h1>

			<br />
			<br />
			<hr>
			<br />
			<table>
				<tr>
					<th>
						商品编号
					</th>
					<th>
						商品名称
					</th>
					<th>
						商品类型
					</th>
					<th>
						库存数量
					</th>
					<th>
						商品上架
					</th>
				</tr>
				<c:forEach var="storagelist" items="${alist}">
					<tr>
						<td>
							${storagelist.cargo_id }
						</td>
						<td>
							${storagelist.cargo_name }
						</td>
						<td>
							${storagelist.cargo_type}
						</td>
						<td>
							${storagelist.storage_num }
						</td>
						<td>
							<a href="AddOnSell?id=${storagelist.cargo_id }">上架</a>
						</td>

					</tr>
				</c:forEach>

			</table>
		</center>

	</body>
</html>
