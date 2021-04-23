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
				パスワード:${empBean.empPass}
			</p>
			<p>
				社員名:${empBean.empName}
			</p>
			<p>
				性別:${empBean.gender}
			</p>
			<p>
				住所:${empBean.address}
			</p>
			<p>
				生年月日:${empBean.birthday}
			</p>
			<p>
				権限:${empBean.authority}
			</p>
			<p>
				部署名:${empBean.deptName}
			</p>
		<form action="<%=request.getContextPath()%>/Delete1" method="post">
			<input type="hidden" name="empId" value="${empBean.empId} "/>
			<input type="submit" value="実行" />
			<input type="button" value="戻る"/>
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>