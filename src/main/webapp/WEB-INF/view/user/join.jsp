<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<a href="login">로그인 돌아가기</a>
	</div>
	<div>
		<form action="join" method="post">
			<div><input type="text" name="id" placeholder="아이디"></div>
			<div><input type="password" name="pw" placeholder="비밀번호"></div>
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div>
				성별 <label>남성</label><input type="radio" name=gender value=0></label>
				<label>여성<input type="radio" name=gender value=1 checked></label>
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>