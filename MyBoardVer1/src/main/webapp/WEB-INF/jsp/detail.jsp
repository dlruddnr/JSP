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
	<h1>detail</h1>
	<div><a href="/list">리스트</a></div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.tcnt}</div>
	<div><a href="/mod?iboard=${data.iboard}">수정</a></div>
	<div><a href="/del?iboard=${data.iboard}">삭제</a></div>
	<div><a href="/comment?iboard=${data.iboard}">댓글달기</a></div>
	<div>댓글창</div>
	<table>
		<tr><th>내용</th><th>시간</th></tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.tcnt}</td><td>${item.regdt}</td>	
			</tr>
		</c:forEach> 
	</table>
</body>
</html>