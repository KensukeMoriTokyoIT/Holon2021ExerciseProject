<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<article class="main">
		<p>社員削除完了画面</p>
		<p>社員情報削除処理が完了しました。</p>
		<form action="<%=request.getContextPath() %>" method="post">
		<input type="submit" value="社員一覧に戻る"/>
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>