<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<title>社員変更完了画面</title>
</head>
<body>
  <%@include file="/jsp/common/header.jsp"%>
  <article class="main">
    <h2>社員変更完了画面</h2>
    <p>社員情報変更処理が完了しました</p>
    <form action="<%=request.getContextPath()%>/jsp/sample17/pizza_update.jsp" method="post">
      <input type="submit" value="社員一覧に戻る" />
    </form>
  </article>
  <%@include file="/jsp/common/footer.jsp"%>
</body>
</html>
