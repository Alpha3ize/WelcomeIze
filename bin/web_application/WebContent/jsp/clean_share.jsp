<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	    <input type="text" name="検索(仮)"><input type="submit" value="検索">
	</form>
	<c:forEach var="" items=""></c:forEach>
	<h3>${}</h3>
	<br>
	<c:forEach var="" items="${}">
		${name}：${Date}<br>
		<tab>${}<br>
		<br>
	</c:forEach>
</body>
</html>