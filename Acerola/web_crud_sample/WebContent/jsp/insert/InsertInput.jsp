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

		<form action="<%=request.getContextPath()%>/online/authority/InsertCheck" id="inputform" method="post">
			<table class="tac">
				<tr>
					<th>社員名:</th>
					<td style="border-style: none; text-align: center;"><input
						type="text" name="empName"  maxlength="30"><label
						style="color: red">${eName}</label></td></tr>
						<tr>
					<th>パスワード:</th>
					<td style="border-style: none; text-align: center;"><input
						type="password" name="empPass"  maxlength="16"><label
						style="color: red">${ePass}</label></td></tr>

				<tr>
					<th>性別:</th>
					<td>
								<input type="radio" name="gender" value="1" checked="checked">男性<label
									style="color: red">${eGender}</label>
								<input type="radio" name="gender" value="2">女性
					</td>

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
					<td>
								<input type="radio" name="authority" value="1" checked="checked">一般
					<input type="radio" name="authority" value="2" id="inputform">管理<label
									style="color: red">${eAuthority}</label>

					</td>

				</tr>
				<tr>
					<th>部署名:</th>
					<td>
								<select name="deptId">
									<option value="1" selected>営業部</option>
									<option value="2">経理部</option>
									<option value="3">総務部</option>
								</select>
								<label style="color: red">${eDept}</label>

						</td>

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