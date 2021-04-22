<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員情報更新入力</title>

</head>
<body>

	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>
		<div id="main">
			<div class="contents">
				<form id="updateForm" method="post"
					action="<%=request.getContextPath()%>/UpdateCheckServlet">
					<p style="color: red">${errorMessage}</p>
				</form>

				<div id="main">
					<h2>社員情報更新入力画面</h2>
					<table class="updateinput">
						<tr>
							<th>社員名：</th>
							<td style="border-style: none; text-align: center;"><input
								type="text" name="empName" maxlength="30"
								value="${updateForm.empName}" /></td>
						</tr>
						<tr>
							<th>性別:</th>
							<td><label><input type="radio" name="authority"
									value="1" ${updateForm.gender == 1?"checked=\"checked\"":""}
									checked="checked">男性</label>
									<label><input type="radio"
									name="authority" value="1"
									${updateForm.gender == 2?"checked=\"checked\"":""}
									checked="checked">女性</label></td>
						</tr>

						<tr>
							<th>住所：</th>
							<td style="border-style: none; text-align: center;"><input
								type="text" name="adress" maxlength="60"
								value="${updateForm.address}"></td>
						</tr>
						<tr>
							<th>生年月日：</th>
							<td style="border-style: none; text-align: center;"><input
								type="date" name="birthday" value="${updateForm.birthday}"></td>
						</tr>
						<tr>
							<th>権限：</th>
							<td><label><input type="radio" name="authority"
									value="1" ${updateForm.authority == 1?"checked=\"checked\"":""}
									checked="checked">一般</label> <label><input type="radio"
									name="authority" value="1"
									${updateForm.authority == 2?"checked=\"checked\"":""}
									checked="checked">管理</label></td>
						</tr>
						<tr>
							<th>部署名：</th>

							<td><select name="deptId">
									<option value="1" ${updateForm.deptId == 1?"selected":""}>営業部</option>
									<option value="2" ${updateForm.deptId == 2?"selected":""}>経理部</option>
									<option value="3" ${updateForm.deptId == 3?"selected":""}>総務部</option>
							</select></td>
						</tr>



					</table>

					<form method="Post"
						action="<%=request.getContextPath()%>/UpdateCheckServlet">
						<input type="hidden" name="empPass" value="${updateForm.empPass}" />
						<input type="submit" value="更新確認" />
					</form>
					<form action="<%=request.getContextPath()%>/ManageTopServlet">
						<input type="submit" value="社員一覧に戻る" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>