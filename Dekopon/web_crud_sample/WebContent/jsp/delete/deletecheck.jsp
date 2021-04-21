<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員削除確認画面</title>
</head>
<body>


 <div id="header">
			<%@include file="/jsp/common/header.jsp"%>
 </div>
	<h2>社員情削除確認画面</h2>
 <div id="main">

			<h3>以下の社員情報を削除しますか？</h3>

			<table class="deleatecheck">

				<tr>
					<th>パスワード：</th>
					<td>＊非表示</td>
				</tr>
				<tr>
					<th>社員名：</th>
					<td>${deleteForm.empName }</td>
				</tr>
				<tr>
					<th>性別:</th>
					<td>${deleteForm.gender}</td>
				</tr>
				<tr>
					<th>住所:</th>
					<td>${deleteForm.address}</td>
				</tr>
				<tr>
					<th>生年月日:</th>
					<td>${deleteForm.birthday}</td>
				</tr>
				<tr>
					<th>権限:</th>
					<td>${deleteForm.authority}</td>
				</tr>
				<tr>
					<th>部署名:</th>
					<td>${deleteForm.deptId}</td>
				</tr>
			</table>


		<form action="<%=request.getContextPath()%>/Delete" method="post">
	            		<input type="submit" value="実行" />
	     </form>
	     <form action="<%=request.getContextPath()%>/jsp/manage/manage.jsp" >
		            	<input type="submit" value="戻る" />
		 </form>
 </div>

 <div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
 </div>

</body>
</html>