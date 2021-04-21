<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<body>
<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

			<div class="contents">
			<form action"=<%=request.getContextPath()%>/SelfPasswordInputServlet"method="post">
								</form>
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/SelfPassupdateServlet">
				</form>
								<p style="color: red">${errorMessage}</p>
		<form action="<%=request.getContextPath()%>/InfoRetum"method="post">
					<h1>パスワード変更完了画面</h1>
			<h3>変更が完了しました</h3>




					</form>
					<form action="<%=request.getContextPath()%>/InfoReturn" method="post">
					<input type="submit" value="社員一覧に戻る" />
				</form>
			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

</body>
</html>
