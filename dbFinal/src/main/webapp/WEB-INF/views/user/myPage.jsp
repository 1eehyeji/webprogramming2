<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<label>학번</label>
	<input type="text" name="id" value="${ user.id }"/>	<br/>
	<label>학과</label>
	<input type="text" name="department" value="${ user.department }"/> <br/>
	<label>이름</label>
	<input type="text" name="name" value="${ user.name }"/> <br/>
	<label>성별</label>
	<input type="text" name="gender" value="${ user.gender }"/> <br/>
	<label>학년</label>
	<input type="text" name="grade" value="${ user.grade }"/> <br/>
	<label>휴대폰</label>
	<input type="text" name="phone" value="${ user.phone }"/> <br/>
	<label>이메일</label>
	<input type="text" name="email" value="${ user.email }"/> <br/>
	<label>비밀번호</label>
	<input type="text" name="password" value="${ user.password }"/> <br/>
	
	<input type="submit" value="수정하기" />
</form>
<a href="../register/list" type="button">수강목록</a> 
<a href="logout">로그아웃</a>
</body>
</html>