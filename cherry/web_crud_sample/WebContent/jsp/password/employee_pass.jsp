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
				<form id="passform" method="post" action="<%=request.getContextPath()%>/EmployeePasswordChangeServlet">
								<p style="color: red">${errorMessage}</p>
					<table class="tac">
						<tr>
							<th>パスワード：</th>
							<td style="border-style: none; text-align: center;">
								<input type="password" name="empPass" maxlength="16" />
							</td>
						</tr>
						<tr>
							<th>新しいパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="empNewPass" maxlength="16" />
							</td>
						</tr>
						<tr>
							<th>新しいパスワード(確認用)：</th>
							<td style="border-style: none">
								<input type="password" name="empNewPass" maxlength="16" />
							</td>
						</tr>
						<tr>
							<!--  <td><html:errors property="empPass" /></td> -->
						</tr>

					</table>
					<input type="submit" value="変更" action="<%=request.getContextPath()%>/EmployeePasswordChangeServlet" />
					<input type="submit" value="社員一覧に戻る" action />
				</form>
			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>