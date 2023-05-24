<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
</head>
<body>
	<main>
		<h1>今週の掃除</h1>
		<img>
		<form action="備品管理" method="post">
			<input type="submit" value="備品管理">
		</form>
		
		<div>
			<p>あなたの掃除場所は${cpName}です。</p>
			<hr>
			<p>${"全体周知情報を最新1件の表示"}</p>
			<a href="掃除情報共有画面">もっと見る</a>
		</div>

		<h1>&#009;掃除</h1>
		<c:if test="${userFlag > 0}">
			<a href="掃除の全体周知登録画面">新規登録</a>
			<a href="グループ分け画面">グループ分け</a>
		</c:if>
		<a href="掃除の編集画面">編集</a>
	</main>
	<aside>
		<div>
			<h4>7/12${today}</h4>
			<dl>
				<dt>本日の面談</dt>
				<dd>あるよ</dd>
			</dl>
		</div>
		<h1>面談</h1>
		<a href="面談追加form">登録</a><br>
		<a href="https://3ize.backlog.jp/wiki/TRI/Home">社内Wiki（リンク）</a>
	</aside>
</body>
</html>