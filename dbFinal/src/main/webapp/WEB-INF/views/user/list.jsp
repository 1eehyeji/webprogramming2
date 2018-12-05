<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function() { 
	$("[data-url]").click(function() { 
		var url = $(this).attr("data-url");   
		location.href = url;
	})  
})
</script>
</head>
<body>
<form method="post">
	<h3> 회원 목록 </h3>
	<br/>
	<a href="create" type="button">회원등록</a> <br/><br/>
	<select name="sb">
		<option value="0">전체조회</option>
		<option value="1">id</option>
		<option value="2">이름</option>
	</select>
	<input type="text" name="st" />
	<input type="submit" value="검색" /><br/>
	<table>
		<tr>
			<th>id</th>
			<th>이름</th>
		</tr>
	<c:forEach var="user" items="${ users }">
		<tr data-url="edit?id=${ user.id }">
			<td>${ user.id }</td>
			<td>${ user.name }</td>
		</tr>
	</c:forEach>
	</table>
</form>
</body>
</html>