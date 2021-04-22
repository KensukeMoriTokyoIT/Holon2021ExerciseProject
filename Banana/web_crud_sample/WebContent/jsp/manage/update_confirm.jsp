<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>確認画面</title>
</head>

<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
	<article class="main">

		<h2>社員更新確認画面</h2>
		<h3>以下の内容で社員情報を更新しますか？</h3>

		<div class=table_manage>
			<table>
				<tr>
					<td>パスワード：</td>
					<td>非表示</td>
				</tr>
				<tr>
					<td>社員名：</td>
					<td>${emp.empName}</td>
				</tr>
				<tr>
					<td>性別：</td>
					<c:choose>
						<c:when test="${emp.gender == 1}">
							<td>男性</td>
						</c:when>
						<c:otherwise>
							<td>女性</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>住所：</td>
					<td>${emp.address}</td>
				</tr>
				<tr>
					<td>生年月日：</td>
					<td>${emp.birthday}</td>
				</tr>
				<tr>
					<td>権限：</td>
					<c:choose>
						<c:when test="${emp.authority == 1}">
							<td>一般</td>
						</c:when>
						<c:otherwise>
							<td>管理</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>部署名：</td>
					<c:choose>
						<c:when test="${emp.deptId == 1}">
							<td>営業部</td>
						</c:when>
						<c:when test="${emp.deptId == 2}">
							<td>経理部</td>
						</c:when>
						<c:otherwise>
							<td>総務部</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</div>

		<form method="post"
			action="<%=request.getContextPath()%>/UpdateCompleteServlet">
			<input type="hidden" name="empId" value="${emp.empId}" /> <input
				type="hidden" name="password" value="${emp.empPass}" /> <input
				type="hidden" name="empName" value="${emp.empName}" /> <input
				type="hidden" name="gender" value="${emp.gender}" /> <input
				type="hidden" name="address" value="${emp.address}" /> <input
				type="hidden" name="birthday" value="${emp.birthday}" /> <input
				type="hidden" name="authority" value="${emp.authority}" /> <input
				type="hidden" name="deptId" value="${emp.deptId}" /> <input
				type="submit" value="実行" />
		</form>

		<form method="post" action="<%=request.getContextPath()%>/ManageReturn">
			<input type="submit" value="戻る" />
		</form>
	</article>

	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>