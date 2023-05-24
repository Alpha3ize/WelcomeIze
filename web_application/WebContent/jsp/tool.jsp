<!-- 掃除備品一覧jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>掃除備品</h2>

	<table>

		<tr>
			<th>備品名</th>
			<th>更新日</th>
			<th>備考 (発注状況,在庫数)</th>
		</tr>

		<tr>
			<c:forEach var="name" items="${CleanTool}">
				<td>${CleanTool.name}</td>
			</c:forEach>

			<c:forEach var="updateDate" items="${CleanTool}">
				<td>${CleanTool.updateDate}</td>
			</c:forEach>

			<c:forEach var="content" items="${CleanTool}">
				<td>${CleanTool.content}</td>
			</c:forEach>
		</tr>

	</table>
	<form action="<%=request.getContextPath()%>/jsp/tool.jsp" method="post">
		<!--  後でcssでデザイン変更-->
		<c:forEach var="button" begin="1" end="id" step="1">
			<input type="submit" value="保存" />
			<input type="submit" value="消去" />
		</c:forEach>

		<!-- Javascript専用の追加(+)ボタン -->
		<input type="submit" value="追加" />
	</form>

	<form action="<%=request.getContextPath()%>/jsp/home.jsp" method="post">
		<input type="submit" value="戻る" />
	</form>
</body>
</html>