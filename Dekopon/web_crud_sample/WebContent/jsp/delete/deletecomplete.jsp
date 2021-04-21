<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員削除完了画面</title>
</head>
<body>

		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
			<div id="main">
			<h2>社員削除完了画面</h2>
			<h3>社員情報削除処理が完了しました。</h3>
			  	<form action="<%=request.getContextPath()%>/jsp/manage/manage.jsp" >
			 	<input type="submit" value="戻る" />
                </form>

			 		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
</div>
</body>
</html>