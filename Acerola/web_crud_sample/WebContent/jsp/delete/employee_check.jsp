<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報管理システム</title>
	</head>
	<body>
		<div id="contents">
			<div id="header">
				<%@include file="/jsp/common/header_login.jsp"%>
			</div>
		<p><div>社員削除確認画面</div>
			<div id="main">
				<div class="contents">
	<article class="main">
		<p><font color="red">以下の社員情報を削除しますか？</font></p>
		<table>
			<tr>
				<th><div style="text-align:left">パスワード:</div></th>
				<td>※非表示</td>
			</tr>
			<tr>
				<th><div style="text-align:left">社員名:</div></th>
				<td>${emp.empName}</td>
			</tr>
			<tr>
				<th><div style="text-align:left">性別:</div></th>
				<td><c:choose>
		<c:when test="${emp.gender == 1}">
		男性</c:when>
		<c:when test="${empgender == 2}">女性</c:when></c:choose></td>
			</tr>
			<tr>
				<th><div style="text-align:left">住所:</div></th>
				<td>${emp.address}</td>
			</tr>
			<tr>
				<th><div style="text-align:left">生年月日:</div></th>
				<td>${emp.birthday}</td>
			</tr>
			<tr>
				<th><div style="text-align:left">権限:</div></th>
				<td> <c:choose>
		<c:when test="${emp.authority == 1}">一般</c:when>
		<c:when test="${emp.authority == 2}">管理</c:when></c:choose></td>
			</tr>
			<tr>
				<th><div style="text-align:left">部署名:</div></th>
				<td><c:choose> <c:when test="${emp.deptId == 1}">営業部</c:when>
		<c:when test="${emp.deptId == 2}">経理部</c:when>
		<c:when test="${emp.deptId == 3}">総務部</c:when></c:choose></td>
			</tr>
		</table>
			<form action="<%=request.getContextPath()%>/online/authority/Delete" method="post">
				<input type = "hidden" name = "empId" value = ${emp.empId }>
				<p><input type="submit" value="実行"/></p>
			</form>
			<form action="<%=request.getContextPath()%>/online/authority/ManageTopServlet" id="inputform">
				<input type="submit" value="戻る"/>
			</form>
	</article>
				</div>
			</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
		</div>
	</body>
</html>