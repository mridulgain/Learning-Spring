<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>User form</title>
</head>
<body>
	<h3>Insert</h3>
	<form:form modelAttribute="student" method="POST">
		Roll
		<form:input path="rollNo"/>
		First Name
		<form:input path="firstName"/>
		Last name 
		<form:input path="lastName"/>
		<input type=submit name=dbSelection value="DoingSomething" formaction="dosomething">
		<input type=submit name=dbSelection value="Mongod" formaction="saveDataByNoSql">
		<input type=submit name=dbSelection value="Postgres" formaction="saveDataBySql">
	</form:form>
</body>
</html>