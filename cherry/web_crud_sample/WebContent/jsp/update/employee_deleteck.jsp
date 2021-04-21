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
		<p>社員削除確認画面</p>
		<p>以下の社員情報を削除しますか？</p>
			<p>
				パスワード:${emp.empPass}
			</p>
			<p>
				社員名:${emp.empName}
			</p>
			<p>
				性別:${emp.gender}
			</p>
			<p>
				住所:${emp.address}
			</p>
			<p>
				生年月日:${emp.birthday}
			</p>
			<p>
				権限:${emp.authority}
			</p>
			<p>
				部署名:${emp.deptName}
			</p>
		<form action="<%=request.getContextPath()%>/Delete1" method="post">
			<input type="hidden" name="empId" value="${emp.empId} "/>
			<input type="submit" value="実行" />
			<input type="button" value="戻る"/>
			//ログアウトボタンをどこにつけ、遷移先をどう設定するか
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>