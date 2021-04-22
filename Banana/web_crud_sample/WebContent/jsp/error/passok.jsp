<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更完了画面</title>

<body>
<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/SelfPassupdateServlet">
								<p style="color: red">${errorMessage}</p>
					<h1>パスワード変更完了画面</h1>
			<h3>変更が完了しました</h3>
</form>


					<form action="<%=request.getContextPath()%>/InfoReturn"method="post">
					<input type="submit" value="社員一覧に戻る" />
				</form>
			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
		</div>
</body>
</html>
