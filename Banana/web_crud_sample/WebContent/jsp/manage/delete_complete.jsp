
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

    <h2>社員削除完了画面</h2>
    <h3><center>社員情報削除処理が完了しました。</center></h3>

    <form action="<%=request.getContextPath()%>/DeleteCompleteServlet" method="post">
      <input type="hidden" name="empId" value="${emp.empId}" />
      <input type="submit" value="削除確定" />
    </form>
  </article>

  		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

</body>
</html>