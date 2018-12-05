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
<form action="excelUpload" method="post" enctype="multipart/form-data">
	<label>수강목록 업로드</label>
    <input type="file" name="file" />
    	<button type="submit">업로드</button>     
</form>
<form method="post">
	<h3> 수강 목록 </h3>
	<br/>
	<select name="sb">
		<option value="0">전체조회</option>
		<option value="1">과목코드</option>
		<option value="2">과목명</option>
	</select>
	<input type="text" name="st" />
	<input type="submit" value="검색" /><br/>
	<table>
		<tr>
			<th>학번</th>
			<th>년도</th>
			<th>학기</th>
			<th>과목코드</th>
			<th>과목명</th>
			<th>이수구분</th>
			<th>학점</th>
			<th>성적등급</th>
		</tr>
	<c:forEach var="register" items="${ registers }">
		<tr>
			<td>${ register.userId }</td>
			<td>${ register.year }</td>
			<td>${ register.semester }</td>
			<td>${ register.courseCode }</td>
			<td>${ register.courseName }</td>
			<td>${ register.completeDivision }</td>
			<td>${ register.unit }</td>
			<td>${ register.credit }</td>
		</tr>
	</c:forEach>
	</table>
</form>
<a href="../user/logout">로그아웃</a>
</body>
</html>