<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員削除確認画面</title>
</head>
<body>


		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<h2>社員情削除確認画面</h2>
			<h3>以下の社員情報を削除しますか？</h3>

			<table class="deleatecheck">

				<tr>
					<th>パスワード：</th>
					<td>＊非表示</td>
				</tr>
				<tr>
					<th>社員名：</th>
					<td>${deleteForm.EmpName }</td>
				</tr>
				<tr>
					<th>性別:</th>
					<td>${deleteForm.Gender}</td>
				</tr>
				<tr>
					<th>住所:</th>
					<td>${deleteForm.Address}</td>
				</tr>
				<tr>
					<th>生年月日:</th>
					<td>${deleteForm.Birthday}</td>
				</tr>
				<tr>
					<th>権限:</th>
					<td>${deleteForm.Authority}</td>
				</tr>
				<tr>
					<th>部署名:</th>
					<td>${deleteForm.DeptId}</td>
				</tr>
			</table>
		</div>

		<form action="<%=request.getContextPath()%>/DeleteForm" method="post">
	            		<input type="submit" value="実行" /><br> 
		            	<input type="submit" value="戻る" />
		</form>

		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

</body>
</html>