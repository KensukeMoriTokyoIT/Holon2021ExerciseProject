<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報登録入力</title>

</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<h2>社員情報登録入力画面</h2>
           <table class="tac">
                        	<tr>
							<th>パスワード：</th>
							<td style="border-style: none">
								<input type="password" name="empPass" maxlength="16" />
							</td>

						<tr>
							<th>社員名：</th>
							<td style="border-style: none; text-align: center;">
								<input type="text" name="empId" maxlength="30" />
							</td>
						</tr>
						<tr>
						    <th>性別:</th>
						    <td >
						   <label><input style="radio" name="gender" value="1">男性</label>
						   <label><input style="radio" name="gender" value="2">女性</label>

						    </td>
						</tr>

						<tr>
						   <th>住所：</th>
						   <td style="border-style:none; text-align: center;">
						    <input type="text" name="adress" maxlength="60";>
						    </td>
						 </tr>
					 <tr>
						  <th>生年月日：</th>
						   <td >
						   </td>
				      </tr>
					  <tr>
						    <th>権限：</th>
						    <td >
						    <label><input type="radio" name="authority"value="1">一般</label>
						    <label><input type="radio" name="authority" value="2">管理</label>
						    </td>
					   </tr>
					   <tr>
					        <th>部署名：</th>
					        <td><form action="<%=request.getContextPath() %>/">
					          <select name="dept">
					           <option value="




					          </select>





					        </form>
							<!--  <td><html:errors property="empPass" /></td> -->
						</tr>
					</table>
					<input type="submit" value="登録確認" />
						<input type="submit" value="社員一覧に戻る" />

</body>
</html>