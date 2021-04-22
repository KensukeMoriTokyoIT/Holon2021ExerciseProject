<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員変更入力画面</title>

</head>
<body>


<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
</div>
<div id="contents">
   <div id="main">
			<h2>社員情報変更入力画面</h2>
			<h3>変更する社員の情報を入力してください</h3>

      <table class="insertinput">

           <tr>
		   <th>社員名： </th>
		   <td style="border-style: none; text-align: center;">
		   <input type="text" name="empName"maxlength="30" />
		   <p style="color: red">${error}</p>
		   </td>
		   </tr>
		　 <tr>
		   <th>性別:</th>
		   <td >
		   <label><input type="radio" name="gender" value="1">男性</label>
		   <label><input type="radio" name="gender" value="2">女性</label>
		   <p style="color: red">${error}</p>
　　　　　 </td>
		   </tr>
           <tr>
		   <th>住所：</th>
		   <td style="border-style:none; text-align: center;">
		   <input type="text" name="address" maxlength="60">
		   <p style="color: red">${error}</p>
		   </td>
		   </tr>
		   <tr>
		   <th>生年月日：</th>
		   <td> <input type ="date" name="birthday">
		   <p style="color: red">${error}</p>
		   </td>
		   </tr>
		  <tr>
		   <th>部署名：</th>
		   <td>
		   <select name="department">
	       <option value="1">営業部 </option>
		   <option value="2">経理部 </option>
		   <option value="3">総務部 </option>
		   <p style="color: red">${error}</p>
		   </select>
           </td>
           </tr>
           <c:forEach var="errorMessage" items="${errorMessages}">
									<tr>
										<td><font color=red>${errorMessage}</font></td>
									</tr>
								</c:forEach>

  </table>
   <form action="<%=request.getContextPath() %>/InsertServlet">
  <input type="submit" value="更新確認" />
  </form>
   <form action="<%=request.getContextPath() %>/InfoTopServlet">
  <input type="submit" value="社員一覧に戻る" />
  </form>
</div>
</div>
  	<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>
