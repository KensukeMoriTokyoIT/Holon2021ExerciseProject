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
		<%@include file="/jsp/common/header.jsp"%>
	</div>
	<article class="main">
		<p>社員登録完了画面</p>
		<p class="cen">社員登録処理が完了しました。</p>

		<form action="<%=request.getContextPath() %>/ManageTopServlet" method="get">
			<input type="submit" value="社員一覧に戻る"/>
		</form>
	</article>

	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>