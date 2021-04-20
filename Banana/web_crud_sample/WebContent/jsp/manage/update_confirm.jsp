@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>確認画面</title>
</head>

<body>
	<div id="header">
		<%@include file="/jsp/common/header.jsp"%>
	</div>
  <article class="main">

    <h2>社員削除確認画面</h2>
    <h3>以下の社員情報を削除しますか？</h3>

<div class="table_manage">
				<table border="1" class="w90p" id="managetable">
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
								<form method="get" action="<%=request.getContextPath()%>/UpdateInputServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="更新" />
								</form>
							</td>
							<td>
								<form method="post" action="<%=request.getContextPath()%>/ManagePasswordInputServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="変更" />
								</form>
							</td>
							<td>
								<form method="post" action="<%=request.getContextPath()%>/DeleteConfirmServlet">
									<input type="hidden" name="empId" value="${emp.empId}" />
									<input type="submit" value="削除" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>





<h1>社員情報変更入力画面</h1>








</body>

<body>

