<!-- 利用者登録確認 岡部大輝-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者登録</title>
</head>
<body>
	<table>
		<tr>
			<th>番号</th>
			<th>氏名</th>
			<th>メールアドレス</th>
			<th>パスワード</th>
			<th>リーダー判定</th>
		</tr>
		<c:if test="${empty userList}">
			<p>csvにファイル内になにもありません。</p>
		</c:if>
		<c:forEach var="users" items="${userList}">
			<tr>
				<td>${users.id}</td>
				<td>${users.name}</td>
				<td>${users.email}</td>
				<td>${users.password}</td>
				<td>${users.flag}</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		上記の内容で登録しますか？
		<br>
		<a href="<%=request.getContextPath()%>/admin_user_confirm">はい</a> <a
			href="<%=request.getContextPath()%>/jsp/admin_user_add.jsp">キャンセル</a>
	</p>
</body>
</html>