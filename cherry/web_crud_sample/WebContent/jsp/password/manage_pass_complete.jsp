<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/web_crud_chery/css/stylesheet.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>パスワード変更完了画面</title>
</head>
<body>
<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
			    <h2>パスワードを変更しました。</h2>
   				 <form method="get" action="<%=request.getContextPath()%>/ManageTopServlet" >
      				<input type="submit" value="検索画面に戻る" />
   				 </form>
			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>
