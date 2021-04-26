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

			<h3>登録する社員の情報を入力してください</h3>
			<form method="post" action="<%=request.getContextPath()%>/manage/InsertConfirmServlet">

				<table class="tac w500">
					<tr>
						<th>パスワード</th>
						<td>
							<input type="password" name="empPass" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorPassword}</p>
						</td>
					</tr>
					<tr>
						<th>氏 名</th>
						<td>
							<input type="text" name="empName" value="${insertForm.empName}" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorName}</p>
						</td>
					</tr>
					<tr>
						<th>性 別</th>
						<td>
							<input type="radio" name="gender" value="1" <c:if test="${insertForm.gender == 1}"> checked="checked" </c:if> />
							男性
							<input type="radio" name="gender" value="2" <c:if test="${insertForm.gender == 2}"> checked="checked" </c:if> />
							女性
						</td>
						<td>
							<p style="color: red">${errorGender}</p>
						</td>
					</tr>
					<tr>
						<th>住 所</th>
						<td>
							<input type="text" name="address" value="${insertForm.address}" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorAddress}</p>
						</td>
					</tr>
					<tr>
						<th>生年月日</th>
						<td>
							<input type="text" name="birthday" value="${insertForm.birthday}" maxlength="10" />
						</td>
						<td>
							<p style="color: red">${errorBirthday}</p>
						</td>
					</tr>
					<tr>
						<th>権 限</th>
						<td>
							<input type="radio" name="authority" value="1"
								<c:if test="${insertForm.authority == 1}"> checked="checked" </c:if> />
							一般
							<input type="radio" name="authority" value="2"
								<c:if test="${insertForm.authority == 2}">checked="checked" </c:if> />
							管理者
						</td>
						<td>
							<p style="color: red">${errorAuthority}</p>
						</td>
					</tr>
					<tr>
						<th>部署名</th>
						<td>
							<select name="deptId">
								<c:forEach var="dept" items="${deptList}" varStatus="status">
									<c:if test="${!(status.first)}">
										<option value="${dept.deptId}" <c:if test="${(insertForm.deptId == dept.deptId)}"> selected="selected" </c:if>>${dept.deptName}</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
						<td>
							<p style="color: red">${errorDeptId}</p>
						</td>
					</tr>
				</table>

				<input type="submit" value="登録確認" />
			</form>
			<form method="get" action="<%=request.getContextPath()%>/manage/ManageTopServlet">
				<input type="submit" value="社員一覧表示に戻る" />
			</form>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>

</body>
</html>