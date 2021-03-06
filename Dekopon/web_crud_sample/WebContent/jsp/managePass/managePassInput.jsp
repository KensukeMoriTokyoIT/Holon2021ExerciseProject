<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				action="<%=request.getContextPath()%>/ManagePassComplete">

<table>
					<tr>
						<th>新しいパスワード</th>
						<td><input type="password" name="newPass" maxlength='15' /></td>

					</tr>
					<tr>
						<th>新しいパスワード(再入力)</th>
						<td><input type="password" name="newPassTwo" maxlength='15' /></td>

					</tr>

             <tr>  <c:forEach var="error" items="${errorMessages}">

             <td><font color=red> ${error}</font></td>
              </c:forEach></tr>
</table>


				<input type="hidden" name="empId" value="${empBean.empId}" />
				<input type="submit" value="変更" />
			</form>

			<form method="get"
				action="<%=request.getContextPath()%>/ManageTopServlet">
				<input type="submit" value="社員一覧に戻る" />
			</form>

		</div>

		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>

</body>
</html>