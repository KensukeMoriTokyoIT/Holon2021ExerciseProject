<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/stylesheet.css" rel="stylesheet"/>
<title>社員情報管理システム</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<article class="main">
		<p>社員登録入力画面</p>
		<form action="<%=request.getContextPath()%>/Check1" method="post">
		<%--エラーメッセージ未実装　エラーメッセージのサーブレット有　牧野君と問題点共通--%>
			<p>
				パスワード:<input type="password" name="empPass" />
			</p>
			<p>
				社員名:<input type="text" name="empName" />
			</p>
			<p>
				性別:<label><input type="radio" name="gender" value="1" />男</label>
					 <label><input type="radio" name="gender" value="2"/>女</label>
			</p>
			<p>
				住所:<input type="text" name="address" />
			</p>
			<p>
				生年月日:<input type="text" name="birthday" />(YYYY/MM/DD)
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
			<input type="submit" value="登録確認" />
			<input type="button" value="社員一覧表示に戻る">
			<%--ログアウトボタンと登録ボタンをどこにつけ、遷移先をどう設定するか--%>
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>