<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name="홍길동";
	pageContext.setAttribute("name","A");
	request.setAttribute("name","B");
	session.setAttribute("name", "C");
	application.setAttribute("name", "D");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><a href="/list">list로 돌아가기</a></div>
	<div>쿼리스트링 ${param.no},${param.age} </div>
	<!--param 뒤에 키값으로 받는다  -->
	<div>제목 : ${vo.title} </div>
	<div>내용 : ${vo.ctnt}</div>
	<div>
		<a href="/mod?no=${param.no}">수정</a>
		<a href="/del?no=${param.no}">삭제</a>
	</div>
	<!--EL식, 잘못되면 빈칸으로 나온다 -->
</body>
</html>