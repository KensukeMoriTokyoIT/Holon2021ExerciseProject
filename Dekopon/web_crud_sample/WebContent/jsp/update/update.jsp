<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員情報更新入力</title>

</head>
<body>

<div id="contents">
		<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
		</div>
		<div id="main">
			<div class="contents">
				<form id="updateForm" method="post" action="<%=request.getContextPath()%>/UpdateCheckServlet">
								<p style="color: red">${errorMessage}</p>

		<div id="main">
			<h2>社員情報更新入力画面</h2>
           <table class="updateinput">
                        	<tr>
							<th>パスワード：</th>
							<td style="border-style: none">
								<input type="password" name="empPass" maxlength="16" />
							</td>
							</tr>

						<tr>
							<th>社員名：</th>
							<td style="border-style: none; text-align: center;">
								<input type="text" name="empName" maxlength="30"value="${updateForm.empName}" />
							</td>
						</tr>
						<tr>
						    <th>性別:</th>
						    <td >
						    <c:choose>
						    	<c:when test="${updateForm.gender==1}">
						   		<label><input type="radio" name="gender" value="1" checked="checked">男性</label>
						   		<label><input type="radio" name="gender" value="2">女性</label>
								</c:when>
								<c:when test="${updateForm.gender==2}">
						   		<label><input type="radio" name="gender" value="1">男性</label>
						   		<label><input type="radio" name="gender" value="2" checked="checked">女性</label>
								</c:when>
								<c:otherwise>
								<label><input type="radio" name="gender" value="1">男性</label>
						   		<label><input type="radio" name="gender" value="2">女性</label>
						   		</c:otherwise>
							</c:choose>
						  
						    </td>
						</tr>

						<tr>
						   <th>住所：</th>
						   <td style="border-style:none; text-align: center;">
						    <input type="text" name="adress" maxlength="60"value="${updateForm.address}">
						    </td>
						 </tr>
					 <tr>
						  <th>生年月日：</th>
						   <td> <input type ="date" name="birthday"value="${updateForm.birthday}">
						   </td>
				      </tr>
					  <tr>
						    <th>権限：</th>
						    <td >
						     <c:choose>
						    	<c:when test="${updateForm.authority==1}">
						   		<label><input type="radio" name="authority" value="1" checked="checked">一般</label>
						   		<label><input type="radio" name="authority" value="2">管理</label>
								</c:when>
								<c:when test="${updateForm.authority==2}">
						   		<label><input type="radio" name="authority" value="1">一般</label>
						   		<label><input type="radio" name="authority" value="2" checked="checked">管理</label>
								</c:when>
								<c:otherwise>
								<label><input type="radio" name="authority" value="1">一般</label>
						   		<label><input type="radio" name="authority" value="2">管理</label>
						   		</c:otherwise>
							</c:choose>
						    </td>
					   </tr>
							<tr>
					        <th>部署名：</th>

					          <td><select name="deptId">
				        	         <option value="1">営業部 </option>
					                 <option value="2">経理部 </option>
					                 <option value="3">総務部 </option>
					           </select></td>
					           </tr>
                            </form>


					</table>
					<input type="submit" value="更新確認" />
					<input type="submit" value="社員一覧に戻る" />
	<div id="footer">
<%@include file="/jsp/common/footer.jsp"%>
</div>
</body>
</html>