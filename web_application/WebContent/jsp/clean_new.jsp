<!-- 掃除場所登録 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>掃除場所追加</h2>

	<table>

		<tr>
			<form action="<%=request.getContextPath()%>/jsp/clean.jsp" method="post">
				<!--  後でcssでデザイン変更-->
				<c:forEach var="button" begin="1" end="id" step="1">
					<th>${CleanPrace.name}</th>
				</c:forEach>
		</tr>

		<tr>
			<c:forEach var="button" begin="1" end="id" step="1">
				<td><input type="submit" value="消去" /></td>
			</c:forEach>
			</form>
		</tr>

		<!-- Javascript専用の追加(+)ボタン -->
		<a href="<%=request.getContextPath()%>/clean.jsp">追加</a>

		<form action="<%=request.getContextPath()%>/jsp/home.jsp" method="post">
			<input type="submit" value="戻る(管理者ページ)" />
		</form>
</body>
</html>