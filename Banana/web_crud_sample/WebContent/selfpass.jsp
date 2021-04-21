<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>一般用パスワード変更画面</title>
</head>

<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header.jsp"%>
		</div>

		<div id="main">
			<div class="contents">
				<form id="loginform" method="post" action="<%=request.getContextPath()%>/SelfPasswordInputServlet">
								<p style="color: red">${errorMessage}</p>
					<table class="pass">
			<p class="tal">パスワード変更入力画面</p>
                          <tr>
                         		<th>現在のパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="oldpass" maxlength="16" />
							</td>
						</tr>
						<tr>
						</tr>
						<tr>
							<th>あたらしいパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="newpass1" maxlength="16" />
							</td>
						</tr>
						<tr>
							<th>あたらしいパスワード：</th>
							<td style="border-style: none">
								<input type="password" name="newpass2" maxlength="16" />
							</td>
							</tr>
						<tr>

				</table>
				<input type="hidden" name="empId" />
				<from action="<%=request.getContextPath()%>/SelfPasswordInputServlet" method="post">
					<input type="submit" value="変更" />
				</from>
				<from action="<%=request.getContextPath()%>/InfoRetum" method="post">
					<input type="submit" value="社員一覧に戻る" />
				</form>


			</div>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>