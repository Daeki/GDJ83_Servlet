<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Weather Detail</h1>
	
	<h3>${requestScope.dto.city}</h3>
	<h3>${requestScope.dto.gion}</h3>
	<h3>${requestScope.dto.huminity}</h3>
	<h3>${requestScope.dto.status}</h3>

</body>
</html>