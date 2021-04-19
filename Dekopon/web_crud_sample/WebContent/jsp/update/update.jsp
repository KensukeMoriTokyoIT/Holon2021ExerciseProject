<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<title>社員変更画面</title>
</head>
<body>
<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
		<div id="main">
			<div class="contents">
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/LoginServlet">
								<p style="color: red">${errorMessage}</p>
</body>
</html>