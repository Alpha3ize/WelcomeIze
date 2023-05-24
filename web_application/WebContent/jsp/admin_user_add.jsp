<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者登録フォーム</title>
</head>
<body>
	<h1>利用者登録</h1>
	<form action="<%=request.getContextPath()%>/admin_user_add" method="post">
		<p>
			ファイルのアップロード：
			<input type="file" name="csvFile" accept="text/csv">
		</p>
		<a href="戻る">戻る</a>
		<input type="submit" value="追加">
	</form>
</body>
</html>