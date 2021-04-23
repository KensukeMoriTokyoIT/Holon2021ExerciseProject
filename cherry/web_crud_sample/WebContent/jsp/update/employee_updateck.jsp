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
		<p>社員情報更新確認画面</p>
		<p>以下の内容で社員情報を更新しますか？</p>
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
		<form action="<%=request.getContextPath()%>/Update1" method="post">
			<input type="hidden" name="empId" value="${emp.empId} "/>
			<input type="hidden" name="empName" value="${emp.empName} "/>
			<input type="hidden" name="gender" value="${emp.gender} "/>
			<input type="hidden" name="address" value="${emp.address} "/>
			<input type="hidden" name="birthday" value="${emp.birthday} "/>
			<input type="hidden" name="authority" value="${emp.authority} "/>
			<input type="hidden" name="deptName" value="${emp.deptName} "/>
			<input type="submit" value="実行" />
			<input type="button" value="戻る"/>
		</form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>