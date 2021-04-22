<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員登録完了画面</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
	<p>
		<font color="red">社員登録完了画面</font>
	</p>

	<form action="<%=request.getContextPath()%>/ManageTopServlet" method="get">
		<p style="text-align:center"><input type="submit" value="社員一覧に戻る" 	/>
	</form>


</body>
</html>