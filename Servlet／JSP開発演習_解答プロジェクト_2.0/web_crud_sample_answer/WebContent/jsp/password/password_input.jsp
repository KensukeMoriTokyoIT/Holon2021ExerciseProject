<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>パスワード変更画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
		<div id="main">

			<h3>パスワードを入力してください</h3>
			<form id="inputform" method="post" action="<%=request.getContextPath()%>/manage/ManagePasswordCompleteServlet">

				<table class="tac">
					<tr>
						<th></th>
						<td>
							<p style="color: red">${passwordMismatch}</p>
						</td>
					</tr>
					<tr>
						<th>新しいパスワード</th>
						<td>
							<input type="password" name="empPass" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorPassword}</p>
						</td>
					</tr>
					<tr>
						<th>新しいパスワード(再入力)</th>
						<td>
							<input type="password" name="empPassTwo" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorPasswordTwo}</p>
						</td>
					</tr>
				</table>

				<input type="hidden" name="empId" value="${emp.empId}" />
				<input type="submit" value="変更" />
			</form>
			<form method="get" action="<%=request.getContextPath()%>/manage/ManageTopServlet">
				<input type="submit" value="社員一覧表示に戻る" />
			</form>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>

</body>
</html>