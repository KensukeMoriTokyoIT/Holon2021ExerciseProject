<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>

	<p style="display: inline">社員情報更新確認画面</p>
	<div id="main">
		<p>
			<font color="red">以下の内容で社員情報を更新しますか？</font>
		</p>
		<p>社員名： ${user.empName}</p>
		<p>性別: <c:choose>
		<c:when test="${user.gender == 1}">
		男性</c:when>
		<c:when test="${user.gender == 2}">女性</c:when></c:choose></p>
		<p>住所: ${user.address}</p>
		<p>生年月日: ${user.birthday}</p>
		<p>権限: <c:choose>
		<c:when test="${user.authority == 1}">一般</c:when>
		<c:when test="${user.authority == 2}">管理</c:when></c:choose>
		<p>部署名:<c:choose> <c:when test="${user.deptId == 1}">営業部</c:when>
		<c:when test="${user.deptId == 2}">経理部</c:when>
		<c:when test="${user.deptId == 3}">総務部</c:when></c:choose></p>


	<form action="<%=request.getContextPath()%>/MgrUpdateConfirmServlet"  id="inputform"  method="post">
		<input type="hidden" name="empId" value="${user.empId}"/>
		<input type="hidden" name="empName" value="${user.empName}"/>
		<input type="hidden" name="gender" value="${user.gender}"/>
		<input type="hidden" name="address" value="${user.address}"/>
		<input type="hidden" name="birthday" value="${user.birthday}"/>
		<input type="hidden" name="authority" value="${user.authority}"/>
		<input type="hidden" name="deptId" value="${user.deptId}"/>
		<input type="submit" value="更新" />
	</form>
	<form action="<%=request.getContextPath()%>/UpdateInputServlet"  id="inputform"  method="get">
	<input type="hidden" name="empId" value="${user.empId}"/>
		<input type="hidden" name="empName" value="${user.empName}"/>
		<input type="hidden" name="gender" value="${user.gender}"/>
		<input type="hidden" name="address" value="${user.address}"/>
		<input type="hidden" name="birthday" value="${user.birthday}"/>
		<input type="hidden" name="authority" value="${user.authority}"/>
		<input type="hidden" name="deptId" value="${user.deptId}"/>
	<input type = "submit"value = "戻る">
	</form>
</div></body>
</html>

