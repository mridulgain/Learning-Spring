<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student Rec</title>
</head>
<body>
<h2>Server side impl</h2>
	<a href="DemoController/insertdata">Record insertion using form</a><br>
	<a href="DemoController/uploaddata">Record insertion using excel</a><br>
	<h2>client side impl...apis</h2>
	<a href="http://localhost:8080/student_record/TestAPI/roll">Show students by roll</a><br>
	<a href="http://localhost:8080/student_record/TestAPI/insert">insert students by form</a><br>
	<a href="http://localhost:8080/student_record/TestAPI/insert/excel">insert students by file</a>
</body>
</html>