<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員情報登録入力</title>

</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
	社員情報登録入力画面
		<div id="main">

			<h3>登録する社員の情報を入力してください</h3>
			<form action="<%=request.getContextPath()%>/InsertInputServlet.java"method="post">
				<table class="insertinput">
					<tr>
						<th>パスワード：</th>
						<td style="border-style: none"><input type="password"
							name="empPass" maxlength="16" /></td>
					</tr>

					<tr>
						<th>社員名：</th>
						<td style="border-style: none; text-align: center;"><input
							type="text" name="empName" maxlength="30" /></td>
					</tr>
					<tr>
						<th>性別:</th>
						<td><label><input type="radio" name="gender"
								value="1">男性</label> <label><input type="radio"
								name="gender" value="2">女性</label></td>
					</tr>

					<tr>
						<th>住所：</th>
						<td style="border-style: none; text-align: center;">
						<input	type="text" name="address" maxlength="60"></td>
					</tr>
					<tr>
						<th>生年月日：</th>
						<td><input type="date" name="birthday"></td>
					</tr>
					<tr>
						<th>権限：</th>
						<td><label><input type="radio" name="authority"
								value="1">一般</label> <label><input type="radio"
								name="authority" value="2">管理</label></td>
					</tr>

					<tr>
						<th>部署名：</th>
						<td><select name="deptName" >
								<option value="1" selected>営業部</option>
								<option value="2">経理部</option>
								<option value="3">総務部</option>
						</select></td>

					</tr>


				</table>
        </form>
       <form action="<%=request.getContextPath()%>/jsp/Insert/insertcheck.jsp">
		<input type="submit" value="登録確認" />
		</form>
		<form action="<%=request.getContextPath()%>/jsp/manage/manage.jsp">
			<input type="submit" value="社員一覧に戻る" />
		</form>
	</div>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>