<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員登録完了画面</title>
</head>
<body>
　　
  <div id="contents">
  <div id="header">
		<%@include file="/jsp/common/header_login.jsp"%>
  </div>

  <div id="main">
			<h2>社員登録完了画面</h2>
			<h3>社員登録処理が完了しました。</h3>
			   	<form action="<%=request.getContextPath()%>/jsp/manage/manage.jsp" >
	            	<input type="submit" value="社員一覧に戻る" />
	          	</form>
	</div>
	</div>
    <div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
	</div>

</body>
</html>