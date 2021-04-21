<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>パスワード変更入力画面</title>
</head>
<body>
	<div id="contents">

		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<h1>パスワード変更入力画面</h1>

		<div id="main">
			<form method="post"
				action="<%=request.getContextPath()%>/SelfPasswordUpdateServlet">
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<th>現在のパスワード</th>
									<td><input type="password" name="nowPass" maxlength='15' /></td>
								</tr>
								<tr>
									<th>新しいパスワード</th>
									<td><input type="password" name="newPass" maxlength='15' /></td>
								</tr>
								<tr>
									<th>新しいパスワード(再入力)</th>
									<td><input type="password" name="newPassTwo"
										maxlength='15' /></td>
								</tr>
							</table>
						</td>

						<%--エラー文の出力 --%>
						<td>
							<table>
								<c:forEach var="errorMessage" items="${errorMessages}">
									<tr>
										<td><p style="color: red">${errorMessage}</p></td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</table>
				<input type="hidden" name="empId" value="${empBean.empId}" /> <input
					type="submit" value="変更" />
			</form>

			<form method="post"
				action="<%=request.getContextPath()%>/jsp/info/info.jsp">
				<input type="submit" value="社員一覧に戻る" />
			</form>
		</div>

		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>
</body>
</html>