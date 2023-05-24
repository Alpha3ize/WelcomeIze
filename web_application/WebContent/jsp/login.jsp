<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<label>メールアドレス</label> <input type="text" name="email"> <label>パスワード</label>
		<input type="password" name="password"> <input type="submit"
			value="ログイン">
	</form>
</body>
</html>




<c:if test="${user.userId != null}">
</c:if>
<c:if test="${user.userId == null}">
	<h3 class="error">失敗しました</h3>
</c:if>