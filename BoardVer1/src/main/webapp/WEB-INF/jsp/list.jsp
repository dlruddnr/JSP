<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %>    
<%	
List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table,th,td{border : 1px solid black;
					border-collapse:collapse;}
	</style>
</head>
<body>
	<h1>리스트</h1>
	<div>
	<!--a태그는 무조건 get방식-->
		<a href="/write">글쓰기</a> 
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th> 
			</tr>
		<% for(int i=0; i<list.size();i++){
			BoardVO vo=list.get(i);
			%>
			<tr>     
			<td><%=i %></td><td> <a href="/detail?no=<%=i%>"><%=vo.getTitle() %></a></td>
			</tr>
		<%} %>
		</table>
	</div>
	<div>
		글 쓰기 뿌릴공간
	</div>
</body>
</html>