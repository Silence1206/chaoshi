<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>商品列表</title>
		<script LANGUAGE="javascript">
		<!--
		function checkInf(){
		if(searchForm.tiaojian[1].selected)
		{
		searchForm.guanjian.style.display="";
		
		}else{
		searchForm.guanjian.style.display="none";
		}
		}
		function checkInput(){
		if(searchForm.keyword.value.length==0){
			alert("请输入您要查询的信息！");
			searchForm.keyword.foucs();
			return false;
		
		}else{
		searchForm.action="SearchInf";
		}
		
		}
		-->
		
		
		</script>
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
			<p>
			<form action="" name="searchForm" method="post" onclick="checkInf()">
				
					输入查询的条件：
					<select name="tiaojian">
						<option value="mohu">
							模糊查询
						</option>
						<option value="key">
							关键字查询
						</option>
					</select>
					&nbsp;&nbsp;
					<select name="guanjian" style="DISPLAY:none">
						<option value="cargo.Cargo_ID">
							商品编号
						</option>
						<option value="Cargo_Name">
							商品名
						</option>
						<option value="Cargo_Type">
							商品类别
						</option>
						<option value="Sell_Num">
							数量
						</option>
						<option value="Sell_Price">
							单价
						</option>
					</select>
					<input type="text" name="keyword">
					&nbsp;&nbsp;
					<input type="submit" value="提交" onclick="checkInput()">
					&nbsp;&nbsp;
					<input type="reset" value="取消">
			</form>
			</p>
			<table align="center" width="400">
				<tr>
					<th>
						商品编号
					</th>
					<th>
						商品名
					</th>
					<th>
						商品类别
					</th>
					<th>
						数量
					</th>
					<th>
						单价
					</th>
					<th>
						删除
					</th>
					<th>
					编辑
					</th>
				</tr>
				<c:forEach var="cargo" items="${array}">
					<tr>
						<td>
							${cargo.cargo_id}
						</td>
						<td>
							${cargo.cargo_name}
						</td>
						<td>
							${cargo.cargo_type}
						</td>
						<td>
							${cargo.sell_num}个
						</td>
						<td>
							${cargo.sell_price}￥
						</td>
						<td>
							<a href="DeleteCargo?id=${cargo.cargo_id }">删除</a>
						</td>
						<td>
							<a href="EidtCargo?id=${cargo.cargo_id }">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
