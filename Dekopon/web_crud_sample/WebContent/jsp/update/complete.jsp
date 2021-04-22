<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員情報更新完了画面</title>
</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<div id="main">
			<div class="contents"></div>


			<article class="main">
				<h3>社員情報更新処理が完了しました。</h3>
				<h3 style="color: red"></h3>
				<form action="<%=request.getContextPath()%>/jsp/update/update.jsp"
					method="post">
					<input type="submit" value="社員一覧に戻る" />
				</form>
			</article>
		</div>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>