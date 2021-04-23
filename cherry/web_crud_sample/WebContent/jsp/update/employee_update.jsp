<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet"/>
<title>社員情報管理システム</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
		<p>社員情報更新入力画面</p>
	<div id="main">
		<form action="<%=request.getContextPath()%>/Check2" method="post">
				<input type="hidden" name="empId" value="${empBean.empId}">
			<table class="check_tac">
				<tr>
					<td>社員名:</td>
					<td><input type="text" name="empName" value="${empBean.empName}"/></td>
					<td></td>
					<td style="color: red">${errorMessage_name}</td>
				</tr>
				<tr>
					<td>性別:</td>
					<td>
						<label><input type="radio" name="gender" <c:if test="${empBean.gender == 1}">checked</c:if> value="1"  />男</label>
						<label><input type="radio" name="gender" <c:if test="${empBean.gender == 2}">checked</c:if> value="2"  />女</label>
					</td>
					<td></td>
					<td style="color: red">${errorMessage_gender}</td>
				</tr>
				<tr>
					<td>住所:</td>
					<td><input type="text" name="address" value="${empBean.address}"/></td>
					<td></td>
					<td style="color: red">${errorMessage_address}</td>
				</tr>
				<tr>
					<td>生年月日:</td>
					<td><input type="text" name="birthday" value="${empBean.birthday}" /></td>
					<td></td>
					<td style="color: red">${errorMessage_birthday}</td>
				</tr>
				<tr>
					<td>権限:</td>
					<td>
						<label><input type="radio" name="authority" <c:if test="${empBean.authority == 1}">checked</c:if> value="1" />一般</label>
						<label><input type="radio" name="authority" <c:if test="${empBean.authority == 2}">checked</c:if> value="2" />管理</label>
					</td>
					<td></td>
					<td style="color: red">${errorMessage_authority}</td>
				</tr>
				<tr>
					<td>部署名:</td>
					<td>
						<select name="deptName">
						<option value="1">営業部</option>
						<option value="2">経理部</option>
						<option value="3">総務部</option>
						</select>
					</td>
					<td></td>
					<td style="color: red">${errorMessage_pass}</td>
				</tr>
			</table>
			<input type="submit" value="更新" />
		</form>
		<form id="inputform" method="get" action="<%=request.getContextPath()%>/ManageTopServlet">
			<input type="submit" value="社員一覧表示に戻る">
		</form>
		</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>