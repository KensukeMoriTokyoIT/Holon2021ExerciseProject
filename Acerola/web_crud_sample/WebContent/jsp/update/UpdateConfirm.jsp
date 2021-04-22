<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>更新しました</title>
</head>
<body>
<div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>

	<p style="display: inline">社員情報変更完了画面</p>
	<div id="main">
		<p>
			<font color="red">社員情報の更新しました。</font>
		</p>
		<c:choose>
		<c:when test="${user.authority == 2}">
		<form action="<%=request.getContextPath()%>/ManageTopServlet"  id="inputform"  method="get">
	<input type = "submit"value = "社員情報一覧に戻る">
	</form></c:when>
	<c:when test="${user.authority == 1}">
		<form action="<%=request.getContextPath()%>/InfoTopServlet"  id="inputform"  method="get">
	<input type = "submit"value = "社員情報一覧に戻る">
	</form></c:when>
	 </c:choose>
	</div>
</body>
</html>