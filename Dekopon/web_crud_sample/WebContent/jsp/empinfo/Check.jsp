<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員変更確認画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>

	<div id="main">
		<h2>社員変更確認画面</h2>
		<h3>以下の内容で社員情報を変更しますか？</h3>

	        <table class="insertcheck">
						<tr>
							   <th>パスワード：</th>
							   <td>＊非表示
						    	</td>
						</tr>
						<tr>
							 <th>社員名：</th>
							 <%-- (オブジェクト生成時の変数.beanのreturn) --%>
							 <td>${emp.empName}
							 </td>
						</tr>
						<tr>
							<th>性別:</th>
							<td><p>${message}</p>
							</td>
						</tr>
						<tr>
						    <th>住所:</th>
						    <td>${emp.address}
						    </td>
						</tr>
						<tr>
						    <th>生年月日:</th>
						    <td>${emp.birthday}
						    </td>
						 </tr>
						 <tr>
						     <th>権限:</th>
						     <td>${emp.authority}
						     </td>
						 </tr>
						 <tr>
						     <th>部署名:</th>
						     <td>${emp.deptName}
						     </td>
						  </tr>


	</table>
	  <form action ="<%=request.getContextPath() %>/CheckServlet" method="post">
	   <input type="hidden" name="empName" value="${insertform.empName}"/>
	   <input type="hidden" name="gender" value="${insertform.gender}"/>
	   <input type="hidden" name="adress" value="${insertform.adress}"/>
	   <input type="hidden" name="birthday" value="${insertform.birthday}"/>
	   <input type="hidden" name="department" value="${insertform.depertment}"/>
      </form>
	  <input type="submit" value="実行" />
	  <input type="submit" value="戻る" />
	<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
</body>
</html>