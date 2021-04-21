<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>社員変更入力画面</title>

</head>
<body>

<div id="contents">
<div id="header">
			<%@include file="/jsp/common/header_login.jsp"%>
</div>

   <div id="main">
			<h2>社員変更入力画面</h2>
			<h3>変更する社員の情報を入力してください</h3>
   <form action="<%=request.getContextPath() %>/InsertServlet" method="get">
      <table class="insertinput">
           <tr>
		   <th>パスワード：</th>
		   <td style="border-style: none">
		   <input type="password" name="empPass" maxlength="16" />
		   <p style="color: red">${errormessage}</p>
		   </td>
		   </tr>
           <tr>
		   <th>社員名：
		   <td style="border-style: none; text-align: center;">
		   <input type="text" name="empName" maxlength="30" />
		   <p style="color: red">${errormessage1}</p>
		   </th>
		   </td>
		   </tr>
		　 <tr>
		   <th>性別:</th>
		   <td >
		   <label><input type="radio" name="gender" value="1">男性</label>
		   <label><input type="radio" name="gender" value="2">女性</label>
		   <p style="color: red">${errormessage2}</p>
　　　　　 </td>
		   </tr>
           <tr>
		   <th>住所：</th>
		   <td style="border-style:none; text-align: center;">
		   <input type="text" name="address" maxlength="60">
		   <p style="color: red">${errormessage3}</p>
		   </td>
		   </tr>
		   <tr>
		   <th>生年月日：</th>
		   <td> <input type ="date" name="birthday">
		   <p style="color: red">${errormessage4}</p>
		   </td>
		   </tr>
		   <tr>
		   <th>権限：</th>
		   <td >
		   <label><input type="radio" name="authority"value="1">一般</label>
		   <label><input type="radio" name="authority" value="2">管理</label>
		   <p style="color: red">${errormessage5}</p>
		   </td>
		   </tr>
		   <th>部署名：</th>
		   <td>
		   <select name="department">
	       <option value="1">営業部 </option>
		   <option value="2">経理部 </option>
		   <option value="3">総務部 </option>
		   <p style="color: red">${errormessage6}</p>
		   </select>
           </td>
  </form>
  </table>
  <input type="submit" value="更新確認" /></br>
  <input type="submit" value="社員一覧に戻る" />
	<div id="footer">
			<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>