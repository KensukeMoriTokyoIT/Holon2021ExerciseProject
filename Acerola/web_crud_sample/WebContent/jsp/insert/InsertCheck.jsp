<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員登録確認画面</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>

	<p style="display: inline">社員登録確認画面</p>
	<div id="main">
		<p>
			<font color="red">以下の内容で社員情報を登録しますか？</font>
		<p>パスワード: ※非表示</p>
		<p>社員名： ${user.empName}</p>
		<p>
			性別:
			<c:choose>
				<c:when test="${user.gender == 1}">
		男性</c:when>
				<c:when test="${user.gender == 2}">女性</c:when>
			</c:choose>
		</p>
		<p>住所: ${user.address}</p>
		<p>生年月日: ${user.birthday}</p>
		<p>
			権限:
			<c:choose>
				<c:when test="${user.authority == 1}">一般</c:when>
				<c:when test="${user.authority == 2}">管理</c:when>
			</c:choose>
		<p>
			部署名:
			<c:choose>
				<c:when test="${user.deptId == 1}">営業部</c:when>
				<c:when test="${user.deptId == 2}">経理部</c:when>
				<c:when test="${user.deptId == 3}">総務部</c:when>
			</c:choose>
		</p>
	</div>

	<form action="<%=request.getContextPath()%>/InsertComplete" id="main"
		method="post">
		<input type="hidden" name="empPass" value="${emp.empPass}" /> <input
			type="hidden" name="empName" value="${emp.empName}" /> <input
			type="hidden" name="gender" value="${emp.gender}" /> <input
			type="hidden" name="address" value="${emp.address}" /> <input
			type="hidden" name="birthday" value="${emp.birthday}" /> <input
			type="hidden" name="authority" value="${emp.authority}" /> <input
			type="hidden" name="deptId" value="${emp.deptId}" />
		<p style="text-align: center">
			<input type="submit" value="実行" />
	</form>


</body>
</html>