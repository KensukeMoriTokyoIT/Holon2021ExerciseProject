<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/web_crud_chery/css/stylesheet.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>パスワード変更入力画面</title>
</head>
<body>
<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
			<form action="<%=request.getContextPath()%>/ManagePasswordUpdateServlet"
				 id="passform" method="post" >
								<p style="color: red">${errorMessage}</p>
					<table class="tac">
						<tr>
							<th>新しいパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="empPass" maxlength="16" />
							</td>
						</tr>
						<tr>
							<th>新しいパスワード(確認用)：</th>
							<td style="border-style: none">
								<input type="password" name="empRePass" maxlength="16" />
							</td>
						</tr>

					</table>
					<input type="submit" value="変更" />
			</form>

					<form method="get" action="<%=request.getContextPath()%>/ManageTopServlet">
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