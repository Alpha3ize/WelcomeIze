<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>全体報告画面</h3>
	<form action="<%=request.getContextPath()%>/jsp//.jsp">
		<input type="text" name="検索(仮)">
		<input type="submit" value="検索">
	</form>
	<c:if test="${管理者flag = 2 }">
		<a><input type="hidden" name="管理者のみ見える" value="新規登録"></a>
	</c:if>
	<c:forEach var="" items="">
		<c:forEach var="" items="">
	${日付} ${報告表示}<input type="submit" value="消去">
		</c:forEach>
	</c:forEach>
	<br>
	<a href="今日の掃除の詳細ページ">戻る</a>
</body>
</html>