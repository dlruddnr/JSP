<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>comment</h1>
	<div><a href="/list">리스트</a></div>
	<form action="/comment" method="post">
	<div>댓글내용 : <textarea name="tcnt"></textarea></div>
	<input type="hidden" name="iboard" value="${data}">
	<input type="submit" value="댓글달기">
	</form>
</body>
</html>