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
	<a href="/write">글쓰기</a>
	<div>글 리스트가 보 일 부 분</div>
	<c:forEach var="i" begin="1" end="5" step="1">
	<!--step default값은 1  -->
	<div>${i}</div>
	</c:forEach>
	
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
		</tr>
		<c:forEach var="item" items="${list}" varStatus="status">
		<tr>
		<td>${status.index}</td>
		<td><a href="/detail?no=${status.index}">${item.title}</a></td>
		<!--index count first last  -->
		</tr>
		</c:forEach>
	</table>
</body>
</html>