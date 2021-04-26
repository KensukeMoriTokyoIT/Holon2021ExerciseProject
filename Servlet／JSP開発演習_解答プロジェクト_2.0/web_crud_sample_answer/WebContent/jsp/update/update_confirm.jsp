<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報変更画面</title>
</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<h3>この内容で変更しますか？</h3>
			<table class="tac w300">
				<tr>
					<th>パスワード</th>
					<td>※非表示</td>
				</tr>
				<tr>
					<th>氏 名</th>
					<td>
						<c:out value="${updateForm.empName}" />
					</td>
				</tr>
				<tr>
					<th>性 別</th>
					<td>${updateForm.gender == 1 ? "男性" : "女性"}</td>
				</tr>
				<tr>
					<th>住 所</th>
					<td>
						<c:out value="${updateForm.address}" />
					</td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td>
						<c:out value="${updateForm.birthday}" />
					</td>
				</tr>
				<tr>
					<th>権 限</th>
					<td>${updateForm.authority == 2 ? "管理者" : "一般"}</td>
				</tr>
				<tr>
					<th>部署名</th>
					<td>
						<c:out value="${updateForm.deptName}" />
					</td>
				</tr>
			</table>
			<form method="post" action="<%=request.getContextPath()%>/manage/UpdateCompleteServlet">
				<input type="hidden" name="empId" value="${updateForm.empId}" />
				<input type="hidden" name="empPass" value="${updateForm.empPass}" />
				<input type="hidden" name="empName" value="${updateForm.empName}" />
				<input type="hidden" name="gender" value="${updateForm.gender}" />
				<input type="hidden" name="address" value="${updateForm.address}" />
				<input type="hidden" name="birthday" value="${updateForm.birthday}" />
				<input type="hidden" name="authority" value="${updateForm.authority}" />
				<input type="hidden" name="deptId" value="${updateForm.deptId}" />
				<input type="submit" value="実行" />
			</form>
			<form method="post" action="<%=request.getContextPath()%>/manage/UpdateInputServlet">
				<input type="hidden" name="empId" value="${updateForm.empId}" />
				<input type="hidden" name="empPass" value="${updateForm.empPass}" />
				<input type="hidden" name="empName" value="${updateForm.empName}" />
				<input type="hidden" name="gender" value="${updateForm.gender}" />
				<input type="hidden" name="address" value="${updateForm.address}" />
				<input type="hidden" name="birthday" value="${updateForm.birthday}" />
				<input type="hidden" name="authority" value="${updateForm.authority}" />
				<input type="hidden" name="deptId" value="${updateForm.deptId}" />
				<input type="submit" value="戻る" />
			</form>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>