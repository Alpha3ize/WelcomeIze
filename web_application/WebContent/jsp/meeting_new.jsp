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
<form action="<%=request.getContextPath()%>/check16" method="post">
<p>日時：<input type="date" name="meetDate" /></p>
<p>場所 ：<input type="text" name="meetPlace" /><p>
<!-- nameタグは仮のネーミング -->
<p>メンバー：<select name="meetMember">
<%= for %>
<option value="001" ></option>
</select></p>
<input type="button" >
<input type="submit" value="登録" />
</form>
</article>
</body>
</html>