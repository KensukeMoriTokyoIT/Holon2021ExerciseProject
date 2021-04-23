<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<article class="main">
		<p>社員登録確認画面</p>
		<p>以下の内容で社員情報を登録しますか？</p>
			<p>
				パスワード:※非表示
			</p>
			<p>
				社員名:${emp.empName}
			</p>
			<p>
				性別:${emp.gender == 1 ? "男性" : "女性"}
			</p>
			<p>
				住所:${emp.address}
			</p>
			<p>
				生年月日:${emp.birthday}
			</p>
			<p>
				権限:${emp.authority == 2 ? "管理者" : "一般"}
			</p>
			<p>
				部署名:${emp.deptName}
			</p>
		<form action="<%=request.getContextPath()%>/Insert1" method="post">
			<input type="hidden" name="empPass" value="${emp.empPass} "/>
			<input type="hidden" name="empName" value="${emp.empName} "/>
			<input type="hidden" name="gender" value="${emp.gender} "/>
			<input type="hidden" name="address" value="${emp.address} "/>
			<input type="hidden" name="birthday" value="${emp.birthday} "/>
			<input type="hidden" name="authority" value="${emp.authority} "/>
			<input type="hidden" name="deptName" value="${emp.deptName} "/>
			<input type="submit" value="実行" />
      				<input type="submit" value="戻る" />
   				 </form>
	</article>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>