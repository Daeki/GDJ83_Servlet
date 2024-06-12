<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>학생 목록</h1>
	
	<!-- <tag attribute="" >contents</tag> -->
	
	<div>
		<img alt="" src="/resources/images/dog2.jpg">
	</div>
	

	<table class="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Avg</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- for(데이터타입 변수명:배열명) -->
			<c:forEach items="${requestScope.list}" var="student">
				<tr>
				<td>${pageScope.student.num}</td>
				<td>${pageScope.student.name}</td>
				<td>${pageScope.student.avg}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>