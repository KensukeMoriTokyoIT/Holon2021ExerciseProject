<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員更新確認画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
	<%@include file="/jsp/common/header_login.jsp"%>
		</div>

	<div id="main">
		<h2>社員更新確認画面</h2>
		<h3>以下の内容で社員情報を更新しますか？</h3>

	        <table class="updatecheck">
                       	<tr>
							   <th>パスワード：</th>
							   <td>＊非表示
						    	</td>
						</tr>
						<tr>
							 <th>社員名：</th>
							 <td>${updateform.empName}
							 </td>
						</tr>
						<tr>
							<th>性別:</th>
							<td>${updateform.gender}
							</td>
						</tr>
						<tr>
						    <th>住所:</th>
						    <td>${updateform.adress}
						    </td>
						</tr>
						<tr>
						    <th>生年月日:</th>
						    <td>${updateform.birthday}
						    </td>
						 </tr>
						 <tr>
						     <th>権限:</th>
						     <td>${updateform.authority}
						     </td>
						 </tr>
						 <tr>
						     <th>部署名:</th>
						     <td>${updateform.depertment}
						     </td>
						  </tr>


	</table>
	  <form action ="<%=request.getContextPath() %>/updatecheck" method="post">

	  <input type="hidden" name="empPass" value="${updateform.empPass }"/>
	   <input type="hidden" name="empName" value="${updateform.empName}"/>
	   <input type="hidden" name="gender" value="${updateform.gender}"/>
	    <input type="hidden" name="adress" value="${updateform.adress}"/>
	    <input type="hidden" name="birthday" value="${updateform.birthday}"/>
	    <input type="hidden" name="authority" value="${updateform.authority}"/>
	     <input type="hidden" name="department" value="${updateform.depertment}"/>








	  </form>
					<input type="submit" value="実行" />
						<input type="submit" value="戻る" />
	<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
		</div>
</body>
</html>