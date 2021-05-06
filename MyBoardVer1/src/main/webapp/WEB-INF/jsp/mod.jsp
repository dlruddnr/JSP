<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>mod</h1>
	<form action="/mod" method="post">
	<div>제목 : <input name="title" type="text" value="${data.title}"></div>
	<div>내용 : <textarea name="tcnt">${data.tcnt}</textarea></div>
	<input type="hidden" name="iboard" value="${data.iboard}">
	<input type="submit" value="수정하기">
	</form>
</body>
</html>