<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table,td,tr,th{border: 1px solid black; border-collapse: collapse;}
	.record{cursor: pointer;}
	.record:hover{background-color: gray; }
</style>
</head>
<body>
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard})">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		function moveToDetail(asd){
			//console.log(asd);
			location.href='/detail?iboard='+asd
		}
	</script>
</body>
</html>