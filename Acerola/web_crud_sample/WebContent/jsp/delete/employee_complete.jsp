<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
		<title>社員情報管理システム</title>
	</head>
	<body>
		<div id="contents">
			<div id="header">
				<%@include file="/jsp/common/header_login.jsp"%>
			</div>
		<p><div>社員削除完了画面</div></p>
		<div id="main">
				<div class="contents">
		<article class="main">
		<p><font color="red">社員情報削除処理が完了しました。</font></p>
		<form action="<%=request.getContextPath()%>/jsp/delete/employee_check.jsp"
		method="post">										<!-- 社員情報一覧へ飛ばす -->
			<input type="submit" value="社員一覧に戻る"/>
		</form>
	</article>
	</div>
		</div>
			<div id="footer">
				<%@include file="/jsp/common/footer.jsp"%>
			</div>
		</div>
	</body>
</html>