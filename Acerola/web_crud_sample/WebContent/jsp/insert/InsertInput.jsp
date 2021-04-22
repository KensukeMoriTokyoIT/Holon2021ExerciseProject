<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員登録入力画面</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>

	<p style="display: inline">社員登録入力画面</p>
	<div id="main">
		<p>
			<font color="red">登録する社員の情報を入力してください</font>
		</p>

		<form action="<%=request.getContextPath()%>/InsertCheck" id="inputform" method="post">
			<table class="tac">
				<tr>
					<th>社員名:</th>
					<td style="border-style: none; text-align: center;"><input
						type="text" name="empName" value="${user.empName}" maxlength="30"><label
						style="color: red">${eName}</label></td>
				<tr>
					<th>性別:</th>
					<td><c:choose>
							<c:when test="${user.gender == 1}">
								<input type="radio" name="gender" value="1" checked="checked">男性<label
									style="color: red">${eGender}</label>
								<input type="radio" name="gender" value="2">女性
					</c:when>
							<c:when test="${user.gender == 2}">
								<input type="radio" name="gender" value="1">男性<label
									style="color: red">${eGender}</label>
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
						value="${user.birthday}">(yyyy/MM/dd)<label
						style="color: red">${eBirthday}</label></td>

				</tr>
				<tr>
					<th>権限:</th>
					<td><c:choose>
							<c:when test="${user.authority == 1}">
								<input type="radio" name="authority" value="1" checked="checked">一般
					<input type="radio" name="authority" value="2" id="inputform">管理<label
									style="color: red">${eAuthority}</label>
							</c:when>
							<c:when test="${user.authority == 2}">
								<input type="radio" name="authority" value="1">一般
					<input type="radio" name="authority" value="2" checked="checked">管理<label
									style="color: red">${eAuthority}</label>
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
								</select>
								<label style="color: red">${eDeptName}</label>
							</c:when>
							<c:when test="${user.deptId == 2}">
								<select name="deptId" id=>
									<option value="1">営業部</option>
									<option value="2" selected>経理部</option>
									<option value="3">総務部</option>
								</select>
								<label style="color: red">${eDeptName}</label>
							</c:when>
							<c:when test="${user.deptId == 3}">
								<select name="deptId">
									<option value="1">営業部</option>
									<option value="2">経理部</option>
									<option value="3" selected>総務部</option>
								</select>
								<label style="color: red">${eDeptName}</label>

							</c:when>
						</c:choose></td>

				</tr>
			</table>
			<p ><input type ="submit" value="登録確認" />
		</form>
	</div>

	<form action="<%=request.getContextPath() %>/jsp/info/info.jsp" method="post">
	<p style="text-align:center"><input type ="submit" value="社員情報一覧表示に戻る" /></p>
	</form>


	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>