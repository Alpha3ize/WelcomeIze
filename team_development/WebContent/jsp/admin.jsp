<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ページ</title>
</head>
<body>
	<h2>管理者用ページ</h2>
	<br />
	<form action="<%request.getContextPath()%>/userAdd" methot="post">
		<input type="submit" name=""value="利用者登録"> <br />
	</form>
	<form action="<%request.getContextPath()%>/userConfirm" methot="post">
		<input type="submit" name=""value="利用者表示"> <br />
	</form>
	<form action="<%request.getContextPath()%>/leaderDecide" methot="post">
		<input type="submit" name=""value="リーダー登録"><br />
	</form>
	<form action="<%request.getContextPath()%>/cPlaceAdd" methot="post">
		<input type="submit" name=""value="掃除追加"> <br />
	</form>
	<form action="<%request.getContextPath()%>methot="post">
	
	<%--以下終わってません。Jジャバスクリプトでやる？
	
		<input type="submit" value="次の掃除場所に変更"> <br />
	</form>
	<a href="<%request.getContextPath()%>/login">戻る（ホーム） </a>--%>

</body>
</html>