<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<article class="main">
		<p>社員情報更新入力画面</p>
		<form action="<%=request.getContextPath()%>/SelfUpdatecheck_info" method="post">


			<p>
				社員名:<input type="text" name="empName" value="${empBean.empName }"/>
			</p>
			<p>
				性別:<label><input type="radio" name="gender"  <c:if test="${empBean.gender == '1'}">checked</c:if> value="男" /> 男</label>
					 <label><input type="radio" name="gender"  <c:if test="${empBean.gender == '2'}">checked</c:if> value="女" />女 </label><br>
			</p>
			<p>
				住所:<input type="text" name="address" value="${empBean.address }"/>
			</p>
			<p>
				生年月日:<input type="text" name="birthday" value="${empBean.birthday }" />
			</p>
			<p>
				部署名:<select name="deptName">
					<option value="営業部">営業部</option>
					<option value="経理部">経理部</option>
					<option value="総務部">総務部</option>
				</select>
			</p>
			<input type="submit" value="更新" />
			</form>
			<form action="<%=request.getContextPath()%>/jsp/info/info.jsp"method="post">
			<input type="button" value="社員一覧表示に戻る"></form>

	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>