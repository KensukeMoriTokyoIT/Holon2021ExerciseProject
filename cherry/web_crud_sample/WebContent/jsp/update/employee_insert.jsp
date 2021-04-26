<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet"/>
<title>社員情報管理システム</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>

		<p>社員登録入力画面</p>
		<p class="cen" style="color: red">登録する社員の情報を入力してください</p>
	<div id="main">
		<form id="inputform" method="post" action="<%=request.getContextPath()%>/Check1" >
		<%--エラーメッセージ未実装　エラーメッセージのサーブレット有　牧野君と問題点共通--%>

		<table class="check_tac">
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="empPass" /></td>
				<td></td>
				<td style="color: red">${errorMessage_pass}</td>
			</tr>
			<tr>
				<td>社員名:</td>
				<td><input type="text" name="empName" /></td>
				<td></td>
				<td style="color: red">${errorMessage_name}</td>
			</tr>
			<tr>
				<td>性別:</td>
				<td>
					<label><input type="radio" name="gender" value="1" />男</label>
					<label><input type="radio" name="gender" value="2"/>女</label>
				</td>
				<td></td>
				<td style="color: red">${errorMessage_gender}</td>
			</tr>
			<tr>
				<td>住所:</td>
				<td><input type="text" name="address" /></td>
				<td></td>
				<td style="color: red">${errorMessage_address}</td>
			</tr>
			<tr>
				<td>生年月日:</td>
				<td><input type="text" name="birthday" /></td>
				<td>(YYYY/MM/DD)</td>
				<td style="color: red">${errorMessage_birthday}</td>
			</tr>
			<tr>
				<td>権限:</td>
				<td>
					<label><input type="radio" name="authority" value="1" />一般</label>
					<label><input type="radio" name="authority" value="2"/>管理</label>
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
				<td style="color: red">${errorMessage_dept}</td>
			</tr>
		</table>
				<input type="submit" value="登録確認">
		</form>
		<form id="inputform" method="get" action="<%=request.getContextPath()%>/ManageTopServlet">
				<input type="submit" value="社員一覧表示に戻る">
		</form>
			<%--ログアウトボタンと登録ボタンをどこにつけ、遷移先をどう設定するか--%>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>