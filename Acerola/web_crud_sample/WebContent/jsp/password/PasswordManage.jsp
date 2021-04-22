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

	<div id=main>
	<form action="<%=request.getContextPath()%>/ManagePass" method="post">
	<input type = "hidden" name = "empId" value ="${user.empId}" >
	<table>
		<tr>
			<td>新しいパスワード</td>
			<td><input
				type="password" name="newPass" maxlength="16"><label style="color: red">${eNewPass}</label></td>
			</tr>
			<tr>
			<td>新しいパスワード(再入力)</td>
			<td><input type="password" name="passCheck" maxlength="16"><label style="color: red">${ePassCheck}</label></td>
		</tr>
	</table>
	<input type="submit" value="変更">
	</form>

<form action="<%=request.getContextPath()%>/ManageTopServlet">
		<input type="submit" value="社員一覧に戻る">
	</form></div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>