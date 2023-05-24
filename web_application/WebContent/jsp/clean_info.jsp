<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全体報告画面</title>
</head>
<body>
	<article class="main">
		<h2>全体報告</h2>
		<form action="<%=request.getContextPath()%>/CleanInfoDao" method="post">
			<input type="text" name="Serch_CleanInfo" />
			<input type="submit" value="検索" />
		</form>


		<form action="<%=request.getContextPath()%>/clean_new" method="post">
			<input type="submit" value="新規登録" />
		</form>


		<table>
			<tr>
				<th>日付</th>
				<th>本文</th>
			</tr>
			<%-- 以下の変数名は適当に設定してあるので編集してください --%>
			<c:forEach var="CleanInfo" items="${CleanInfo_List}">
				<tr>
					<td>${Update_CleanInfo_Date}</td>
					<td>${CleanInfo_text}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/jsp/home.jsp">戻る</a>

	</article>
</body>
</html>