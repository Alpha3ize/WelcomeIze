<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ページ</title>
</head>
<body>
	<h2>管理者用ページ</h2>
	<br />
	<!--ボタン表示のみ完了。画面遷移はまだ-->
	<!-- aタグはまだ -->
	<a href="<%request.getContextPath()%>/"
		<input type="button" name="u_register" value="利用者登録"> </a><br />
		
	<a href="<%request.getContextPath()%>/"
		<input type="button" name="u_look" value="利用者表示"> </a><br />
		
	<a href="<%request.getContextPath()%>/"
		<input type="button" name="l_register" value="リーダー登録"></a><br />
	<a href="<%request.getContextPath()%>/"
		<input type="button" name="c_add" value="掃除追加"></a> <br />
	
	<input type="button" value="次の掃除場所に変更"> <br />
	
	<a href="<%request.getContextPath()%>/to_home">戻る（ホーム） </a>
</body>
</html>