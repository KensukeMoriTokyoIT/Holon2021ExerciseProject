<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>
	<p>パスワード変更入力画面</p>
	<input type="hidden" name="">
	<div id=main>
	<form action="<%=request.getContextPath()%>/Managepass" method="post">
	<table>
		<tr>
			<td>新しいパスワード</td>
			<td><input
				type="password" name="newpass" maxlength="16"></td>
			</tr>
			<tr>
			<td>新しいパスワード(再入力)</td>
			<td><input type="password" name="newpass2" maxlength="16"></td>
		</tr>
	</table>
	<input type="submit" value="変更">
	</form>
</div>
<form action="<%=request.getContextPath()%>/ManageTopServlet">
		<input type="submit" value="社員一覧に戻る">
	</form>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>