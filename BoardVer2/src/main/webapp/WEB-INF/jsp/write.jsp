<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>write</h1>
	<div><a href="/list">돌아가기</a></div>
	<div>
	<form action="/write" method="post">
		<div>제목:<input type="text" name=title></div>
		<div>내용:</div><textarea cols="5" rows="5" name=ctnt></textarea></div>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
	</div> 
</body>
</html>