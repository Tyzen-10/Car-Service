<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Form</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
username is ${username}
${mechname}
${asscar}
${mechid}
<h1>Form</h1>
<div class= "form-container" style = "margin:auto;min-height:200px;min-width:200px;background-color:white;width:600px;text-align:center;">
<form action = "Free" method="post">
	<c:set var="defaultValue" value="${asscar}" />
Car number:<input type="text" name ="" value="<c:out value="${defaultValue}" />" readonly />
	<c:set var="defaultValue2" value="${mechid}" />
Mechanic id:<input type="text" name = "" value="<c:out value="${defaultValue2}" />" readonly /><br>
Enter Report:
<br>
<textarea name="content" rows="5" cols="50"></textarea><br>
<input type = "submit" value = "Submit Report">
</form>
</div>
</body>
</html>