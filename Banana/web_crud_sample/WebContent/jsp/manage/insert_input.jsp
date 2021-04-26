<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <h2>社員登録入力画面</h2>
    <h3>登録する社員の情報を入力してください</h3>

    <form method="post" action="<%=request.getContextPath()%>/InsertConfirmServlet">

	<div class=table_manage>
    <table>
    <tr>
		<td>パスワード：</td>
		<td><input type="password" name="password"></td>
		<td> </td>
		<td>${password_error}</td>
    </tr>
    <tr>
		<td>社員名：</td>
		<td><input type="text" name="empName"></td>
		<td> </td>
		<td>${empName_error}</td>
    </tr>
    <tr>
		<td>性別：</td>
		<td>
		<label><input type="radio" name="gender" value="1"/>男性</label>
		<label><input type="radio" name="gender" value="2"/>女性</label>
		</td>
		<td> </td>
		<td>${gender_error}</td>
    </tr>
    <tr>
		<td>住所：</td>
		<td><input type="text" name="address"></td>
		<td> </td>
		<td>${address_error}</td>
    </tr>
    <tr>
		<td>生年月日：</td>
		<td><input type="text" name="birthday"></td>
		<td>(YYYY/MM/DD)</td>
		<td>${birthday_error}</td>
    </tr>
    <tr>
		<td>権限：</td>
		<td>
		<label><input type="radio" name="authority" value="1"/>一般</label>
		<label><input type="radio" name="authority" value="2"/>管理</label>
		</td>
		<td> </td>
		<td>${authority_error}</td>
    </tr>
    <tr>
		<td>部署名：</td>
		<td>
		<select name="deptId">
		<option value="1">営業部</option>
		<option value="2">経理部</option>
		<option value="3">総務部</option>
		</select>
		</td>
		<td> </td>
		<td>${deptId_error}</td>
    </table>

    </div>
		<input type="hidden" name="empId" value="${emp.empId}" />
		<input type="submit" value="登録確認" />
	</form>

		<form method="post" action="<%=request.getContextPath()%>/ManageReturn">
		<input type="submit" value="社員一覧表示に戻る" />
		</form>
  </article>

  		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

</body>
</html>