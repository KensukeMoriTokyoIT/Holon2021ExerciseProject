<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/redcenter.css"
	rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
	</div>
パスワード変更完了画面
<p>変更が完了しました。</p>
<form action="<%=request.getContextPath()%>/online/InfoTopServlet">
		<input type="submit" value="社員一覧に戻る"></form>
<div id="footer">
<%@include file="/jsp/common/footer.jsp"%>	</div>
</body>
</html>