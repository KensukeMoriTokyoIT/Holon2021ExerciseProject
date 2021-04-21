<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員登録確認画面</title>
</head>
<body>
	<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
	<h2>社員登録確認画面</h2>
	<div id="main">

		<h3>以下の内容で社員情報を登録しますか？</h3>

	        <table class="insertcheck">
                       	<tr>
							   <th>パスワード：</th>
							   <td>＊非表示
						    	</td>
						</tr>
						<tr>
							 <th>社員名：</th>
							 <td>${insertform.empName}
							 </td>
						</tr>
						<tr>
							<th>性別:</th>
							<td>${insertform.gender}
							</td>
						</tr>
						<tr>
						    <th>住所:</th>
						    <td>${insertform.address}
						    </td>
						</tr>
						<tr>
						    <th>生年月日:</th>
						    <td>${insertform.birthday}
						    </td>
						 </tr>
						 <tr>
						     <th>権限:</th>
						     <td>${insertform.authority}
						     </td>
						 </tr>
						 <tr>
						     <th>部署名:</th>
						     <td>${insertform.deptName}
						     </td>
						  </tr>


	</table>

    <form action ="<%=request.getContextPath() %>/jsp/Insert/insertcomplete.jsp" method="post">

	   <input type="hidden" name="empPass" value="${insertform.empPass }"/>
	   <input type="hidden" name="empName" value="${insertform.empName}"/>
	   <input type="hidden" name="gender" value="${insertform.gender}"/>
	   <input type="hidden" name="adress" value="${insertform.address}"/>
       <input type="hidden" name="birthday" value="${insertform.birthday}"/>
       <input type="hidden" name="authority" value="${insertform.authority}"/>
       <input type="hidden" name="department" value="${insertform.deptName}"/>

        <input type="submit" value="実行" />
   	</form>
	<form action ="<%=request.getContextPath() %>/jsp/Insert/insertinput.jsp" method="post">
		<input type="submit" value="戻る" />
	</form>
</div>
</div>
 <div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
 </div>
</body>
</html>