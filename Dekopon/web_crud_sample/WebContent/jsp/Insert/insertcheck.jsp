<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員登録確認画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>
		社員登録確認画面
		<div id="main">

			<h3>以下の内容で社員情報を登録しますか？</h3>

			<table class="insertcheck">
				<tr>
					<th>パスワード：</th>
					<td>＊非表示</td>
				</tr>
				<tr>
					<th>社員名：</th>
					<td>${emp.empName}</td>
				</tr>
				<tr>
					<th>性別:</th>
					<td><c:if test="${emp.gender==1}">
					男性
					</c:if> <c:if test="${emp.gender==2}">
					女性
					</c:if></td>
				</tr>
				<tr>
					<th>住所:</th>
					<td>${emp.address}</td>
				</tr>
				<tr>
					<th>生年月日:</th>
					<td>${emp.birthday}</td>
				</tr>
				<tr>
					<th>権限:</th>
					<td><c:if test="${emp.authority==1}">
					一般
					</c:if> <c:if test="${emp.authority==2}">
					管理
					</c:if></td>
				</tr>
				<tr>
					<th>部署名:</th>
					<c:if test="${emp.authority==1}">
						<td>営業部</td>
					</c:if>
					<c:if test="${emp.authority==2}">
						<td>経理部</td>
					</c:if>
					<c:if test="${emp.authority==3}">
						<td>総務部</td>
					</c:if>
				</tr>


			</table>

			<form
				action="<%=request.getContextPath()%>/InsertCompleteServlet"
				method="post">

				<input type="hidden" name="empPass" value="${emp.empPass }" /> <input
					type="hidden" name="empName" value="${emp.empName}" /> <input
					type="hidden" name="gender" value="${emp.gender}" /> <input
					type="hidden" name="address" value="${emp.address}" /> <input
					type="hidden" name="birthday" value="${emp.birthday}" /> <input
					type="hidden" name="authority" value="${emp.authority}" /> <input
					type="hidden" name="deptId" value="${emp.deptId}" /> <input
					type="submit" value="実行" />
			</form>
			<form action="<%=request.getContextPath()%>/InsertInputServlet"
				method="get">
				<input type="submit" value="戻る" />
			</form>
		</div>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>