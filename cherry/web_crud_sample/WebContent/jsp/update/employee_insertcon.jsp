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
		<p>社員登録完了画面</p>
		<p>社員登録処理が完了しました。</p>
		//コンテキストパス以下のURL設定
		<form action="<%=request.getContextPath() %>" method="post">
		<input type="submit" value="社員一覧に戻る"/>
		</form>
	</article>
	//ログアウトボタンとその遷移先を設定
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>