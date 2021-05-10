<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.koreait.board.*"%>
<%@page import="java.util.*"%>
<% String idx=request.getParameter("no");
	//BoardVO vo=(BoardVO)request.getAttribute("data");
	BoardVO vo =(BoardVO)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>detail 파일 부분<%=request.getParameter("no")%></h1>
	<!--${param.no} EL식???   -->
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value=<%=idx %>>
			<input type="submit" value="삭제">
			
		</form>
		<form action="/mod" method="post">
			<input type="text" name="title" value=<%=vo.getTitle()%> ></input>
			<textarea rows="5" cols="10" name="ctnt"><%=vo.getCtnt()%></textarea>
			<input type="hidden" name="no" value=<%=idx %>>
			<input type="submit" value="수정완료">
		</form>
	</div>
</body>
</html>