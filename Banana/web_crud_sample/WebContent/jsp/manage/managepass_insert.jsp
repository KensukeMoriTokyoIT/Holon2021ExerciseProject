<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />


<title>管理者パスワード変更画面</title>
</head>




<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/ManagePasswordInputServlet">
								<p style="color: red">${errorMessage}</p>
					<table class="tac">
			<h2>パスワード変更入力画面</h2>

						<tr>
							<th>新しいパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="newpass1" maxlength="16" />
							</td>
						</tr>

						<th>新しいパスワード再入力：</th>
							<td style="border-style: none">
								<input type="password" name="newpass2" maxlength="16" />
							</td>
							<!--  <td><html:errors property="empPass" /></td> -->
						</tr>
				</table>


				</form>
			</div>
		</div>



		</form>


<form method="post" action="<%=request.getContextPath()%>/ManageReturn">
		<input type="submit" value="社員一覧表示に戻る" />

		</form>


<form method="post" action="<%=request.getContextPath()%>/ManagePasswordCompleteServlet">
			<input type="hidden" name="empId" value="${emp.empId}" />
			<input type="submit" value="変更" />
</form>



		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>