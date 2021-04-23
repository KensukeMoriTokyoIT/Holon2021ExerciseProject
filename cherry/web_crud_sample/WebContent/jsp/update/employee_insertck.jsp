<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<p>社員登録確認画面</p>
		<p class="cen">以下の内容で社員情報を登録しますか？</p>
		<div id="main">
			<table>
				<tr>
					<td>パスワード:</td>
					<td>※非表示</td>
				</tr>
				<tr>
					<td>社員名:</td>
					<td>${emp.empName}</td>
				</tr>
				<tr>
					<td>性別:</td>
					<td>${emp.gender == 1 ? "男性" : "女性"}</td>
				</tr>
				<tr>
					<td>住所:</td>
					<td>${emp.address}</td>
				</tr>
				<tr>
					<td>生年月日:</td>
					<td>${emp.birthday}</td>
				</tr>
				<tr>
					<td>権限:</td>
					<td>${emp.authority == 2 ? "管理者" : "一般"}</td>
				</tr>
				<tr>
					<td>部署名:</td>
					<td>${emp.deptName}</td>
				</tr>
			</table>
		<form action="<%=request.getContextPath()%>/Insert1" method="post">
			<input type="hidden" name="empPass" value="${emp.empPass} "/>
			<input type="hidden" name="empName" value="${emp.empName} "/>
			<input type="hidden" name="gender" value="${emp.gender} "/>
			<input type="hidden" name="address" value="${emp.address} "/>
			<input type="hidden" name="birthday" value="${emp.birthday} "/>
			<input type="hidden" name="authority" value="${emp.authority} "/>
			<input type="hidden" name="deptName" value="${emp.deptName} "/>
			<input type="submit" value="実行" />
		</form>
			<form method="get" action="<%=request.getContextPath()%>/ManageTopServlet" >
      				<input type="submit" value="戻る" />
   			</form>
   		</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>