<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet"/>
<title>社員情報管理システム</title>
</head>
<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
		<p>社員削除確認画面</p>
	<div id="main">
		<p class="cen" style="color: red">以下の社員情報を削除しますか？</p>
		<table class="check_tac">
			<tr>
				<td>パスワード:</td>
				<td>${empBean.empPass}</td>
			</tr>
			<tr>
				<td>社員名:</td>
				<td>${empBean.empName}</td>
			</tr>
			<tr>
				<td>性別:</td>
				<td>${emp.gender == 1 ? "男性" : "女性"}</td>
			</tr>
			<tr>
				<td>住所:</td>
				<td>${empBean.address}</td>
			</tr>
			<tr>
				<td>生年月日:</td>
				<td>${empBean.birthday}</td>
			</tr>
			<tr>
				<td>権限:</td>
				<td>${emp.authority == 2 ? "管理者" : "一般"}</td>
			</tr>
			<tr>
				<td>部署名:</td>
				<td>${empBean.deptName}</td>
			</tr>
		</table>
		<form action="<%=request.getContextPath()%>/Delete1" method="post">
			<input type="hidden" name="empId" value="${empBean.empId} "/>
			<input type="submit" value="実行" />
		</form>
		<form id="inputform" method="get" action="<%=request.getContextPath()%>/ManageTopServlet">
				<input type="submit" value="戻る">
		</form>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>