<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<title>社員情報管理システム</title>

</head>
<body>
  <%@include file="/jsp/common/header.jsp"%>
  <article class="main">
      <h2>社員情報管理システム</h2>
    <h3>ログイン画面</h3>
    <form action="<%=request.getContextPath()%>/bakery08" method="post">
      名前：<input type="text" name="loginName" /> <br/>
      パスワード：<input type="password" name="password"> <br/>
      <input type="submit" value="ログイン" />
    </form>
  </article>
  <%@include file="/jsp/common/footer.jsp"%>
</body>
</html>