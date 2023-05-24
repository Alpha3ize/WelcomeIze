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
<article class="main">
<h3>面談予定登録画面</h3>
<form action="<%=request.getContextPath()%>/" method="post">
<p>日時：<input type="date" name="meetDate" /></p>
<p>場所 ：<input type="text" name="meetPlace" /><p>
<!-- nameタグは仮のネーミング -->
<p>メンバー：<select name="meetMember">
<c:forEach var="member" items="${メンバー}">
<c:forEach var="val" items="${社員ID }">
<option value="${val}" >${member}</option>
</c:forEach>
</c:forEach>
</select></p>
<input type="button"  value="戻る">
<input type="submit" value="登録" />
</form>
</article>
</body>
</html>