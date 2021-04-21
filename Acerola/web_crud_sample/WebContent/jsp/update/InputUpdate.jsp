<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員更新入力</title>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<%@ include file="/jsp/common/header_login.jsp"%>
	</div>
	<p>社員情報更新入力画面</p>
	<div id="main">
		<form action="<%=request.getContextPath()%>/UpdateCheck">
		<input type = "hidden" value = "${user.empId }">
		<input type ="password" name = "Newpassword" maxlength = "16">
		<input type = "text" value ="${user.empName}">


		<c:choose>
		<c:when test = "${user.empGender == 0}">
		<label><input type = "radio" name = "gender_u" value = "0" selected>男性</label>
		<label><input type = "radio" name = "gender_u" value = "1">女性</label>
		</c:when>
		<c:when test = "${user.empGender == 1}">
		<label><input type = "radio" name = "gender_u" value = "0" >男性</label>
		<label><input type = "radio" name = "gender_u" value = "1" selected>女性</label>
		</c:when>
		</c:choose>

		</form>

	</div>

	<div id="footer">
		<%@ include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>