<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table,tr,td,th{border: 1px solid black; border-collapse: collapse;}
	.line{cursor: pointer;}
	.line:hover{background-color: gray;}
</style>
</head>
<body>
	<h1>list</h1>
	<div><a href="/write">글쓰기</a></div>
	<table>
	<tr>
	<th>IBOARD</th><th>TITLE</th><th>REGDT</th>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr class="line" onclick="moveWeb(${item.iboard})">
		<td>${item.iboard}</td>
		<td>${item.title}</td>
		<td>${item.regdt}</td>
		</tr>
	</c:forEach>
	</table>
	
	
	<script>
		function moveWeb(asd){
			location.href="/detail?iboard="+asd;
		}
	</script>
</body>
</html>