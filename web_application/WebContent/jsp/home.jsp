<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
</head>
<body>
	<main>
		<h1>今週の掃除</h1>
		<img>
		<form action="備品管理" method="post">
			<input type="submit" value="備品管理">
		</form>

		<h1>&#009;掃除</h1>
		<%-- 		<c:if test="${userFlag > 0}"> --%>
		<!-- 			<form action="掃除の全体周知" method="post"> -->
		<!-- 				<input type="submit" value="新規登録"> -->
		<!-- 			</form> -->
		<!-- 			<form action="グループ分け" method="post"> -->
		<!-- 				<input type="submit" value="グループ分け"> -->
		<!-- 			</form> -->
		<%-- 		</c:if> --%>
		<!-- 		<form action="掃除の編集" method="post"> -->
		<!-- 			<input type="submit" value="編集"> -->
		<!-- 		</form> -->
		<!--↓の場合はdoGet()に送られる。 -->
		<c:if test="${userFlag > 0}">
			<a href="掃除の全体周知登録画面">新規登録</a>
			<a href="グループ分け画面">グループ分け</a>
		</c:if>
		<a href="掃除の編集画面">編集</a>

	</main>
</body>
</html>