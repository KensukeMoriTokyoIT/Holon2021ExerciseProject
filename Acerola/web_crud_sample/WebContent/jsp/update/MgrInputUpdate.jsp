<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員更新入力</title>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<%@ include file="/jsp/common/header_login.jsp"%>
	</div>
	<p>社員情報更新入力画面</p>
	<div id="main" id="contents">

		<form action="<%=request.getContextPath()%>/MgrUpdateCheckServlet"
			id="inputform" method="post">
			<input type="hidden" name="empId" value="${user.empId }">
			<table class="tac">

				<tr>
					<th>社員名:</th>
					<td style="border-style: none; text-align: center;"><input
						type="text" name="empName" value="${user.empName}" maxlength="30"><label style="color: red">${eName}</label></td>

				<tr>
					<th>性別:</th>
					<td><c:choose>
							<c:when test="${user.gender == 1}">
								<input type="radio" name="gender" value="1" checked="checked">男性<label style="color: red">${eGender}</label>
					<input type="radio" name="gender" value="2">女性
					</c:when>
							<c:when test="${user.gender == 2}">
								<input type="radio" name="gender" value="1">男性<label style="color: red">${eGender}</label>
					<input type="radio" name="gender" value="2" checked="checked">女性
				</c:when>
						</c:choose></td>

				</tr>
				<tr>
					<th>住所:</th>
					<td><input type="text" name="address" value="${user.address}"
						maxlength="60"><label style="color: red">${eAddress}</label></td>

				</tr>

				<tr>
					<th>生年月日:</th>
					<td><input type="text" name="birthday"
						value="${user.birthday}">(yyyy/MM/dd)<label style="color: red"
						>${eBirthday}</label></td>

				</tr>
				<tr>
					<th>権限:</th>
					<td><c:choose>
							<c:when test="${user.authority == 1}">
								<input type="radio" name="authority" value="1" checked="checked">一般
					<input type="radio" name="authority" value="2" id="inputform">管理<label style="color: red">${eAuthority}</label>
				</c:when>
							<c:when test="${user.authority == 2}">
								<input type="radio" name="authority" value="1">一般
					<input type="radio" name="authority" value="2" checked="checked">管理<label style="color: red">${eAuthority}</label>
				</c:when>
						</c:choose></td>

				</tr>
				<tr>
					<th>部署名:</th>
					<td><c:choose>
							<c:when test="${user.deptId == 1}">
								<select name="deptId">
									<option value="1" selected>営業部</option>
									<option value="2">経理部</option>
									<option value="3">総務部</option>
								</select><label style="color: red">${eDept}</label>
							</c:when>
							<c:when test="${user.deptId == 2}">
								<select name="deptId" id=>
									<option value="1">営業部</option>
									<option value="2" selected>経理部</option>
									<option value="3">総務部</option>
								</select><label style="color: red">${eDept}</label>
							</c:when>
							<c:when test="${user.deptId == 3}">
							<select name="deptId">
									<option value="1">営業部</option>
									<option value="2">経理部</option>
									<option value="3" selected>総務部</option>
								</select><label style="color: red">${eDept}</label>

							</c:when>
						</c:choose></td>

				</tr>
			</table>
			<input type="submit" value="登録画面">

		</form>
		<p></p>
		<form action="<%=request.getContextPath()%>/ManageTopServlet"
			id="inputform">
			<input type="submit" value="社員一覧表示に戻る">
		</form>

	</div>


</body>
<footer>
	<div id="footer">
		<%@ include file="/jsp/common/footer.jsp"%>
	</div>
</footer>
</html>