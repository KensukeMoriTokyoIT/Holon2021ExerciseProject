<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>部署情報登録画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
		<div id="main">

			<h3>登録したい部署名を選択してください</h3>
			<form method="post" action="<%=request.getContextPath()%>/manage/InsertDeptConfirmServlet">

				<table class="tac w500">

					<tr>
						<th>部署名</th>
						<td>
							<input type="text" name="deptName" value="${deptForm.deptName}" maxlength="30" />
						</td>
						<td>
							<p style="color: red">${errorName}</p>
						</td>
					</tr>
				</table>

				<input type="submit" value="登録確認" />
			</form>
			<form method="get" action="<%=request.getContextPath()%>/manage/DeptManageServlet">
				<input type="submit" value="部署一覧表示に戻る" />
			</form>
		</div>
		<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>

	</div>

</body>
</html>