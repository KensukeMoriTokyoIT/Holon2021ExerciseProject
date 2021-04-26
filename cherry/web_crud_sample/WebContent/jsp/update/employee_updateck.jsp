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
		<p>社員情報更新確認画面</p>
	<div id="main">
		<p>以下の内容で社員情報を更新しますか？</p>
		<table class="check_tac">
			<tr>
				<td>社員名:</td>
				<td>${empBean.empName}</td>
			</tr>
			<tr>
				<td>性別:</td>
				<td>${empBean.gender == 1 ? "男性" : "女性"}</td>
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
				<td>${empBean.authority == 2 ? "管理者" : "一般"}</td>
			</tr>
			<tr>
				<td>部署名:</td>
				<td>${empBean.deptName}</td>
			</tr>
		</table>
		<form action="<%=request.getContextPath()%>/Update1" method="post">
			<input type="hidden" name="empId" value="${empBean.empId} "/>
			<input type="hidden" name="empName" value="${empBean.empName} "/>
			<input type="hidden" name="gender" value="${empBean.gender} "/>
			<input type="hidden" name="address" value="${empBean.address} "/>
			<input type="hidden" name="birthday" value="${empBean.birthday} "/>
			<input type="hidden" name="authority" value="${empBean.authority} "/>
			<input type="hidden" name="deptName" value="${empBean.deptName} "/>
			<input type="submit" value="実行" />
		</form>
		<form method="get" action="<%=request.getContextPath()%>/UpdateInputServlet">
			<input type="hidden" name="empId" value="${empBean.empId}" />
			<input type="submit" value="戻る"/>
		</form>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>