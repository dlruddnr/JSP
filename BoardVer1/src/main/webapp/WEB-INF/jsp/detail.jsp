<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.koreait.board.BoardVO" %>
<
 <% 
 	String no = request.getParameter("no"); 
 	BoardVO vo =(BoardVO) request.getAttribute("data");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<h1>디테일 <%=no %></h1>
	<div><%=request.getParameter("no") %></div>
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="<%=no %>">
			<input type="submit" value="삭제">
		</form>
			<a href="/mod?no=<%=no %>"><button>글수정</button></a> 
		<!-- <a href="/del.?no=<%=no %>"></a> -->
	</div>
	<div>제목 : <%=vo.getTitle() %></div>
	<div><%=vo.getCtnt() %> </div>
</body>
</html>
