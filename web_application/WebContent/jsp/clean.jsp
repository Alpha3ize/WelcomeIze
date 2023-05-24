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
	<%-- 以下の変数名は適当に設定してあるので編集してください --%>
	<h2>今日の掃除</h2>
	<h3>過去２日の全体報告</h3>
	<c:forEach var="ClInfo" items="${CleanInfo_List}">
		<tr>
			<td>${ClInfo.cs_body}</td>
		</tr>
	</c:forEach>
	</table>
	<a href="/jsp/clean_info">もっと見る</a>
	
	
	

	<%-- 掃除場所 --%>
	<select>
		<c:forEach var="cleanPlace" items="${CleanPlace_List}">
			<option value="${Cleanplace}>${Cleanplace}</option>
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