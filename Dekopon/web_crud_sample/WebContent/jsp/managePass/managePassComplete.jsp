<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員パスワード変更完了画面</title>
</head>
<body>
	<div id="contents">

		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<h1>パスワード変更完了画面</h1>

		<div id="main">
			<h2>変更が完了しました。</h2>
			<h3	style= color:red ></h3>

			<form method="get"
				action="<%=request.getContextPath()%>/ManageTopServlet">
				<input type="submit" value="社員一覧に戻る" />
			</form>
		</div>

		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>
</body>
</html>