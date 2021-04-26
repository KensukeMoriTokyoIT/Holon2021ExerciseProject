<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>社員情報削除画面</title>
</head>
<body>
  <div id="header">
    <%@include file="/jsp/common/header_login.jsp"%>
  </div>
  <div id="main">

    <h3>この社員の情報を削除しますか？</h3>
    <table class="tac w300">
      <tr>
        <th>社員ID</th>
        <td><c:out value="${emp.empId}" /></td>
      </tr>
      <tr>
        <th>パスワード</th>
        <td>※非表示</td>
      </tr>
      <tr>
        <th>氏名</th>
        <td><c:out value="${emp.empName}" /></td>
      </tr>
      <tr>
        <th>性別</th>
        <td>${emp.gender == 1 ? "男性" : "女性"}</td>
      </tr>
      <tr>
        <th>住所</th>
        <td><c:out value="${emp.address}" /></td>
      </tr>
      <tr>
        <th>生年月日</th>
        <td><c:out value="${emp.birthday}" /></td>
      </tr>
      <tr>
        <th>権限</th>
        <td>${emp.authority == 2 ? "管理者" : "一般"}</td>
      </tr>
      <tr>
        <th>部署名</th>
        <td><c:out value="${emp.deptName}" /></td>
      </tr>
    </table>
    <form method="post"
      action="<%=request.getContextPath()%>/manage/DeleteCompleteServlet">
      <input type="hidden" name="empId" value="${emp.empId}" /> <input
        type="submit" value="実行" />
    </form>

    <form method="get"
      action="<%=request.getContextPath()%>/manage/ManageTopServlet">
      <input type="submit" value="社員一覧表示に戻る" />
    </form>
  </div>

  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>

</body>
</html>