<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="header">社員情報管理システム</h2>

<c:if test="${user != null}">
	<div id="headerinfo">
		<h5 class="login_user">
			ようこそ<b>${user.empName}</b>さん
		</h5>
		<div>
			<form method="get"
				action="<%=request.getContextPath()%>/LogoutServlet">
				<input type="submit" value="ログアウト">
			</form>
		</div>
		<c:choose>
			<c:when test="${user.authority.equals(\"1\")}">
				<form method="get"
					action="<%=request.getContextPath()%>/InfoTopServlet">
					<input type="submit" value="社員情報一覧">
				</form>
			</c:when>
			<c:when test="${user.authority.equals(\"2\")}">
				<form method="get"
					action="<%=request.getContextPath()%>/ManageTopServlet">
					<input type="submit" value="社員情報一覧">
				</form>
				<form method="get"
					action="<%=request.getContextPath()%>/DeptManageServlet">
					<input type="submit" value="部署情報一覧">
				</form>
			</c:when>
		</c:choose>
	</div>
</c:if>
