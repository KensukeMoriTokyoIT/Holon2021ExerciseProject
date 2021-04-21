<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
<title>社員削除確認画面</title>
</head>
<body>


 <div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
 </div>
	<h2>社員情削除確認画面</h2>
 <div id="main">

			<h3>以下の社員情報を削除しますか？</h3>

			<table class="deleatecheck">

				<tr>
					<th>パスワード：</th>
					<td>＊非表示</td>
				</tr>
				<tr>
					<th>社員名：</th>
					<td>${deleteForm.empName }</td>
				</tr>
				<tr><th> 性別: </th>
					<td>
				<c:choose>
					<c:when test="${deleteForm.gender.equals(\"1\") }">
					            男性
					    </c:when>
                         <c:when test="${deleteForm.gender.equals(\"2\") }">
                                女性
                         </c:when>

                     </c:choose>
					</td>
				</tr>
				<tr>
					<th>住所:</th>
					<td>${deleteForm.address}</td>
				</tr>
				<tr>
					<th>生年月日:</th>
					<td>${deleteForm.birthday}</td>
				</tr>
				<tr>
					<th>権限:</th>
						<td>
						<c:choose>
						<c:when test="${deleteForm.authority.equals(\"1\") }">
						        一般
						 </c:when>

					     <c:when test="${deleteForm.authority.equals(\"2\") }">
					            管理
					      </c:when>
					      </c:choose>
					</td>

				</tr>
				<tr>
					<th>部署名:</th>
					<td>${deleteForm.deptName}</td>
				</tr>
			</table>


		<form action="<%=request.getContextPath()%>/Delete" method="post">
	            		<input type="submit" value="実行" />
	     </form>
	     <form action="<%=request.getContextPath()%>/ManageTopServlet" >
		            	<input type="submit" value="戻る" />
		 </form>
 </div>

 <div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
 </div>

</body>
</html>