<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<form action="/mod" method="post">
		<div><input type="text" name="title" value="${data.title}"></input></div>
		<div><textarea cols="10" rows="10" name=ctnt>${data.ctnt}</textarea></div>
		<input type="hidden" name="no" value=${param.no}>
		<input type="submit" value="수정완료">
		</form>
		
</body>
</html>