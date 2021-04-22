<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>更新画面</title>
</head>

<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
	<article class="main">

		<h2>社員更新入力画面</h2>
		<h3>更新する社員の情報を入力してください</h3>

		<div class=table_manage>
			<form method="post"
				action="<%=request.getContextPath()%>/SelfUpdateConfirmServlet">
				<table>
					<tr>
						<td>社員名：</td>
						<td><input type="text" name="empName" value="${emp.empName}">
						<td>${empName_error}</td>
					</tr>
					<tr>
						<td>性別：</td>
						<td><c:choose>
								<c:when test="${emp.gender == 1}">
									<label><input type="radio" name="gender" value="1"
										checked>男性</label>
									<label><input type="radio" name="gender" value="2" />女性</label>
								</c:when>
								<c:otherwise>
									<label><input type="radio" name="gender" value="1"
										checked>男性</label>
									<label><input type="radio" name="gender" value="2"
										checked>女性</label>
								</c:otherwise>
							</c:choose></td>

						<td>${gender_error}</td>

					</tr>
					<tr>
						<td>住所：</td>
						<td><input type="text" name="address" value="${emp.address}"></td>
						<td>${address_error}</td>

					</tr>
					<tr>
						<td>生年月日：</td>
						<td><input type="text" name="birthday"
							value="${emp.birthday}"></td>
						<td>${birthday_error}</td>

					</tr>
					<tr>
						<td>権限：</td>
						<td><c:choose>
								<c:when test="${emp.gender == 1}">
									<label><input type="radio" name="authority" value="1"
										checked>一般</label>
									<label><input type="radio" name="authority" value="2" />管理</label>
								</c:when>
								<c:otherwise>
									<label><input type="radio" name="authority" value="1"
										checked>一般</label>
									<label><input type="radio" name="authority" value="2"
										checked>管理</label>
								</c:otherwise>
							</c:choose></td>
							<td>${authority_error}</td>

					</tr>
					<tr>
						<td>部署名：</td>
						<td><select name="deptId">
								<option value="1">営業部</option>
								<option value="2">経理部</option>
								<option value="3">総務部</option>
						</select>
						<td>${deptId_error}</td>

				</table>

				<input type="hidden" name="password" value="${emp.empPass}" />
				<input type="hidden" name="empId" value="${emp.empId}" /> <input
					type="submit" value="更新確認" />
			</form>
		</div>

		<form method="post"
			action="<%=request.getContextPath()%>/InfoReturn">
			<input type="submit" value="社員一覧表示に戻る" />
		</form>
	</article>

	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>