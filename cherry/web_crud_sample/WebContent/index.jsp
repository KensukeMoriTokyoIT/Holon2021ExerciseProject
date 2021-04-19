<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>ログイン画面</title>
</head>

<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/LoginServlet">
								<p style="color: red">${errorMessage}</p>
					<table class="tac">
						<tr>
							<th>社員ID：</th>
							<td style="border-style: none; text-align: center;">
								<input type="text" name="empId" maxlength="5" />
							</td>
						</tr>
						<tr>
						</tr>
						<tr>
							<th>パスワード：</th>
							<td style="border-style: none">
								<input type="password" name="empPass" maxlength="30" />
							</td>
						</tr>
						<tr>
							<!--  <td><html:errors property="empPass" /></td> -->
						</tr>
					</table>
					<input type="submit" value="ログイン" />
				</form>
			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>