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
	<form action="/clean_info.jsp" method="get">
		<input type="submit" value="もっと見る">
	</form>




	<%-- 掃除場所 --%>
	<!-- プルダウンで表示する場所の一覧 -->
	<form action="/ToCInfo" method="post">
		<select name="selectedPlace" onchange="submit()">
			<c:forEach var="place" items="${placeList}">
				<option value="${place}">${place}</option>
			</c:forEach>
		</select>
	</form>

	<!-- プルダウンで選択した場所に対応する掃除内容 -->
	<p>
		掃除内容：<%= cleaning_content != null ? cleaning_content : "" %></p>

	<!-- 戻るボタン サーブレット処理-->
	<form action="/home.jsp" method="get">
		<input type="submit" value="戻る">
	</form>

</body>
</html>
</body>
</html>