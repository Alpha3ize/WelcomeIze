<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 面談の詳細画面！　田中 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>今日の面談予定！</h3>
	<div class="tomeeting">
		${日時}~${日時}
		<br>
		メンバー：${メンバー}
		<br>
		${場所}
		</br>
	</div>
	<form action="<%=request.getContextPath()%>/">
		<input type="hiddon" name="meeting_id" value="${ミーティングID}">
		<input type="submit" value="編集">
	</form>
	<div class="tomeeting">
		${日時}~${日時}
		<br>
		メンバー：${メンバー}
		<br>
		${場所}
		</br>
	</div>
	<form action="<%=request.getContextPath()%>/">
		<input type="hiddon" name="meeting_id" value="${ミーティングID}">
		<input type="submit" value="編集">
	</form>
	<!-- CSSでボタンにする新規画面に遷移する -->
	<a href="新規登録URL">新規登録</a>
</body>
</html>