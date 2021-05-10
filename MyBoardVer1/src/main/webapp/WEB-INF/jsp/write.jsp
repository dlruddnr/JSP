<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/list" method="post">
	<div>제목 : <input type="text" name="tcnt"></div>
	<div>내용 : <textarea name="title" cols="5" rows="5"></textarea></div>
	<input type="submit" value="저장">
	</form>
</body>
</html>