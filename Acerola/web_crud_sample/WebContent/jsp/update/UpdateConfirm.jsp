<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>更新しました</title>
</head>
<body>
<div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>

	<p style="display: inline">社員登録確認画面</p>
	<div id="main">
		<p>
			<font color="red">社員情報の更新しました。</font>
		</p>
		<form action="<%=request.getContextPath()%>/InfoTopServlet"  id="inputform"  method="get">
	<input type = "submit"value = "社員情報一覧に戻る">
	</form>
	</div>
</body>
</html>