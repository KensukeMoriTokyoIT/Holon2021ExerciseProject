<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<article class="main">
		<p>社員情報更新入力画面</p>
		//コンテキストパス以降のサーブレット未実装
		<form action="<%=request.getContextPath()%>/" method="post">
		//エラーメッセージ未実装　エラーメッセージのサーブレット有　牧野君と問題点共通
		//valueに入力する値はどうする？
			<p>
				<input type="hidden" name="empId" value="">
			</p>
			<p>
				パスワード:<input type="password" name="password" value=""/>
			</p>
			<p>
				社員名:<input type="text" name="name" value=""/>
			</p>
			<p>
				性別:<input type="radio" name="gender" value=""/>
			</p>
			<p>
				住所:<input type="text" name="adress" value=""/>
			</p>
			<p>
				生年月日:<input type="text" name="birthday" value=""/>
			</p>
			<p>
				権限:<input type="radio" name="authority" value=""/>
			</p>
			<p>
				部署名:<select name="department">
					<option value="001">営業部</option>
					<option value="002">経理部</option>
					<option value="003">総務部</option>
				</select>
				//ログアウトボタンと登録ボタンをどこにつけ、遷移先をどう設定するか
			</p>
			<input type="submit" value="更新" />
			<input type="button" value="社員一覧表示に戻る">
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>