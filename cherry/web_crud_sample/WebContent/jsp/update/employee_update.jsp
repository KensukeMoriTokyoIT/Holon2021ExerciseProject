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
		<form action="<%=request.getContextPath()%>/Check2" method="post">
		//エラーメッセージ未実
		//valueに入力する値はどうする？
			<p>
				<input type="text" name="empId" value=>
			</p>
			<p>
				パスワード:<input type="password" name="empPass" value= />
			</p>
			<p>
				社員名:<input type="text" name="empName" value=""/>
			</p>
			<p>
				性別:<label><input type="radio" name="gender" value="1" />男</label>
					 <label><input type="radio" name="gender" value="2"/>女</label>
			</p>
			<p>
				住所:<input type="text" name="address" value=/>
			</p>
			<p>
				生年月日:<input type="text" name="birthday" value= />
			</p>
			<p>
				権限:<label><input type="radio" name="authority" value="1" />一般</label>
					 <label><input type="radio" name="authority" value="2"/>管理</label>
			</p>
			<p>
				部署名:<select name="deptName">
					<option value="1">営業部</option>
					<option value="2">経理部</option>
					<option value="3">総務部</option>
				</select>
			</p>
			<input type="submit" value="更新" />
			<input type="button" value="社員一覧表示に戻る">
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>