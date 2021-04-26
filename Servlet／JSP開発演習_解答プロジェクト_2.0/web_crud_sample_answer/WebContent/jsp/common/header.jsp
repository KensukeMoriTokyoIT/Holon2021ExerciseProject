<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="header">社員情報管理システム</h2>

<c:if test="${user != null}">
	<div id="headerflex">
		<h5 class="login_user">
			ようこそ<b>${user.empName}</b>さん
		</h5>
		<c:if test="${user.authority == 1}">
			<div>
				<form method="get"
					action="<%=request.getContextPath()%>/public/InfoTopServlet">
					<input type="submit" value="社員情報一覧">
				</form>
			</div>
		</c:if>
		<c:if test="${user.authority == 2}">
			<div>
				<form method="get"
					action="<%=request.getContextPath()%>/manage/ManageTopServlet">
					<input type="submit" value="社員情報一覧">
				</form>
			</div>
			<div>
				<form method="post"
					action="<%=request.getContextPath()%>/manage/DeptManageServlet">
					<input type="submit" value="部署情報一覧">
				</form>
			</div>
		</c:if>
		<div>
			<form method="get"
				action="<%=request.getContextPath()%>/LogoutServlet">
				<input type="submit" value="ログアウト">
			</form>
		</div>
	</div>
</c:if>
