<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員更新確認画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<h2>社員更新確認画面</h2>
			<h3>以下の内容で社員情報を更新しますか？</h3>

			<table class="updatecheck">
				<tr>
					<th>パスワード：</th>
					<td>＊非表示</td>
				</tr>

				<tr>
					<th>社員名：</th>
					<td>${updateform.empName}</td>
				</tr>

				<tr>
					<th>性別:</th>
					<td><c:if test="${updateform.gender==1}">
					男性
					</c:if> <c:if test="${updateform.gender==2}">
					女性
					</c:if></td>
				</tr>

				<tr>
					<th>住所:</th>
					<td>${updateform.address}</td>
				</tr>

				<tr>
					<th>生年月日:</th>
					<td>${updateform.birthday}</td>
				</tr>

				<tr>
					<th>権限:</th>
					<td><c:if test="${updateform.authority==1}">
					一般
					</c:if> <c:if test="${updateform.authority==2}">
					管理
					</c:if></td>
				</tr>

				<tr>
					<th>部署名:</th>
					<td><c:if test="${updateform.authority==1}">
					営業部
					</c:if> <c:if test="${updateform.authority==2}">
					経理部
					</c:if> <c:if test="${updateform.authority==3}">
					総務部
					</c:if></td>
				</tr>


			</table>
			<form action="<%=request.getContextPath()%>/updatecheck"
				method="post">
				<input type="hidden" name="empId" value="${updateForm.empId }" /> <input
					type="hidden" name="empPass" value="${updateForm.empPass}" /> <input
					type="hidden" name="empName" value="${updateForm.empName}" /> <input
					type="hidden" name="gender" value="${updateForm.gender}" /> <input
					type="hidden" name="address" value="${updateForm.address}" /> <input
					type="hidden" name="birthday" value="${updateForm.birthday}" /> <input
					type="hidden" name="authority" value="${updateForm.authority}" />
				<input type="hidden" name="department"
					value="${updateForm.department}" />

			</form>
			<input type="submit" value="実行" /> <input type="submit" value="戻る" />
		</div>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>