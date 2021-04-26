<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報登録画面</title>
</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<h3>この内容で登録しますか？</h3>
			<table class="tac w300">
				<tr>
					<th>パスワード</th>
					<td>※非表示</td>
				</tr>
				<tr>
					<th>氏 名</th>
					<td>
						<c:out value="${insertForm.empName}" />
					</td>
				</tr>
				<tr>
					<th>性 別</th>
					<td>${insertForm.gender == 1 ? "男性" : "女性"}</td>
				</tr>
				<tr>
					<th>住 所</th>
					<td>
						<c:out value="${insertForm.address}" />
					</td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td>
						<c:out value="${insertForm.birthday}" />
					</td>
				</tr>
				<tr>
					<th>権 限</th>
					<td>${insertForm.authority == 2 ? "管理者" : "一般"}</td>
				</tr>
				<tr>
					<th>部署名</th>
					<td>
						<c:out value="${insertForm.deptName}" />
					</td>
				</tr>
			</table>
			<form method="post" action="<%=request.getContextPath()%>/manage/InsertCompleteServlet">
				<input type="hidden" name="empPass" value="${insertForm.empPass}" />
				<input type="hidden" name="empName" value="${insertForm.empName}" />
				<input type="hidden" name="gender" value="${insertForm.gender}" />
				<input type="hidden" name="address" value="${insertForm.address}" />
				<input type="hidden" name="birthday" value="${insertForm.birthday}" />
				<input type="hidden" name="authority" value="${insertForm.authority}" />
				<input type="hidden" name="deptId" value="${insertForm.deptId}" />
				<input type="submit" value="実行" />
			</form>
			<form method="post" action="<%=request.getContextPath()%>/manage/InsertInputServlet">
				<input type="hidden" name="empPass" value="${insertForm.empPass}" />
				<input type="hidden" name="empName" value="${insertForm.empName}" />
				<input type="hidden" name="gender" value="${insertForm.gender}" />
				<input type="hidden" name="address" value="${insertForm.address}" />
				<input type="hidden" name="birthday" value="${insertForm.birthday}" />
				<input type="hidden" name="authority" value="${insertForm.authority}" />
				<input type="hidden" name="deptId" value="${insertForm.deptId}" />
				<input type="submit" value="戻る" />
			</form>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>