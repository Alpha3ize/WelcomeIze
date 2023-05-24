<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日の掃除の詳細</title>
</head>
<body>
	<h2>今日の掃除</h2>
	<h3>過去２日の全体報告</h3>
	<c:forEach var="CleanInfo" items="${CleanInfo_List}">
		<tr>
			<td>${CleanInfo_text}</td>
		</tr>
	</c:forEach>
	</table>
	<a href="/jsp/clean_info">もっと見る</a>

	<select>
		<c:forEach var="CleanPlace" items="${CleanPlace_List}">
			<option
				value="${cleanplace}>${cleanplace}</option>
	</c:forEach>
	</select>

	<h3>掃除場所詳細</h3>
	<a href="/jsp/clean_new.jsp">編集</a>
	<c:forEach var="CleanInfo" items="${Cleanplace_List}">
		<tr>
			<td>${Cleanplace_text}</td>
		</tr>
	</c:forEach>
	<a href="/jsp/home.jsp">戻る</a>
</body>
</html>