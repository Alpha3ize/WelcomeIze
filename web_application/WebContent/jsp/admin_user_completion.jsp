<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホームに戻ります</title>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath()%>">
</body>
<script>
window.onload = () => {
	let path = document.getElementById("path").value;
	alert("保存が完了しました");
	location.href = path + '/to_home';
}
</script>
</html>