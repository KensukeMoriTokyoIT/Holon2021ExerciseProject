<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員登録入力画面</title>
</head>
<body>
	<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

	<p>社員登録入力画面</p>

	<p style="text-align:center">パスワード: <input type="text" name="empPass"  maxlength="16"/></p>
	<p style="text-align:center">社員名: <input type="text" name="empName" /></p>
	<p style="text-align:center">性別: <input type="radio" name="gender" value="男性" >男性
									  <input type="radio" name="gender" value="女性" >女性

	<p style="text-align:center">住所 <input type="text" name="address" /></p>
	<p style="text-align:center">生年月日 <input type="text" name="birthday" /></p>
	<p style="text-align:center">権限 <input type="radio" name="authority" value="一般" >一般
									  <input type="radio" name="authority" value="管理" >管理

	<p style="text-align:center">部署名 <select name=”deptName”>
			<option value=”jan”>営業部</option>
			<option value=”feb”>経理部</option>
			<option value=”mar”>総務部</option>
		</select>
	<p style="text-align:center"><input type ="submit" value="登録確認"  />


	<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
</body>
</html>