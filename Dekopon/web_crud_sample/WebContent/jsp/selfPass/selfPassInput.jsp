<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>パスワード変更入力画面</title>
</head>
<body>
	<div id="contents">

		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<h1>パスワード変更入力画面</h1>

		<div id="main">
			<form method="post"
				action="<%=request.getContextPath()%>/SelfPasswordCheckServlet">
				<table>
					<tr>
						<th>現在のパスワード</th>
						<td><input type="text" name="nowPass" /></td>
					</tr>
					<tr>
						<th>新しいパスワード</th>
						<td><input type="text" name="newPass" /></td>
					</tr>
					<tr>
						<th>新しいパスワード(再入力)</th>
						<td><input type="text" name="newPassTwo" /></td>
					</tr>
				</table>

				<input type="hidden" name="empId" value="${empBean.empId}" />
				<input type="submit" value="変更確認" />
			</form>

			<form  method="post"
				action="<%=request.getContextPath()%>/jsp/info/info.jsp">
			<input type="submit" value="一覧に戻る" />
			</form>
		</div>

		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>
</body>
</html>