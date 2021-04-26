<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報一覧画面</title>
</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>
		<div id="main">

			<div class="select_func">
				<form id="selectform" method="post" action="<%=request.getContextPath()%>/manage/ManageSelectServlet">
					<input type="radio" name="radio" value="1" checked="checked" />
					社員ID:
					<input type="text" name="empId" />
					<input type="radio" name="radio" value="2" />
					社員名:
					<input type="text" name="empName" maxlength="30" />
					<input type="radio" name="radio" value="3" />
					部署名:
					<select name="deptId">
						<c:forEach var="dept" items="${deptList}" varStatus="status">
							<option value="${dept.deptId}">${dept.deptName}</option>
						</c:forEach>
					</select>
					<input type="submit" value="検索実行" />
				</form>
				<form method="get" action="<%=request.getContextPath()%>/manage/InsertInputServlet">
					<input type="submit" value="社員新規登録" />
				</form>
			</div>

			<div class="table_manage">
				<table border="1" class="w100p" id="managetable">
					<tr>
						<th>社員ID</th>
						<th>氏名</th>
						<th>性別</th>
						<th>住所</th>
						<th>生年月日</th>
						<th>権限</th>
						<th>部署名</th>
						<th>社員情報更新</th>
						<th>パスワード変更</th>
						<th>社員情報削除</th>
					</tr>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td>
								<c:out value="${emp.empId}" />
							</td>
							<td>
								<c:out value="${emp.empName}" />
							</td>
							<td>${emp.gender == 1 ? "男性" : "女性"}</td>
							<td>
								<c:out value="${emp.address}" />
							</td>
							<td>
								<c:out value="${emp.birthday}" />
							</td>
							<td>${emp.authority == 2 ? "管理者" : "一般"}</td>
							<td>
								<c:out value="${emp.deptName}" />
							</td>
							<td>
								<form method="get" action="<%=request.getContextPath()%>/manage/UpdateInputServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="更新" />
								</form>
							</td>
							<td>
								<form method="post" action="<%=request.getContextPath()%>/manage/ManagePasswordInputServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="変更" />
								</form>
							</td>
							<td>
								<form method="post" action="<%=request.getContextPath()%>/manage/DeleteConfirmServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="削除" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>
		&nbsp;
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>
</body>
</html>