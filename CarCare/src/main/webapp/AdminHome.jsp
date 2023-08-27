<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin FCC</title>
<link rel="stylesheet" href="style.css">
  <script>
  function redirectToServlet() {
      window.location.href = 'Assign'; 
  }
  </script>
</head>
<body>
<nav>
<ul>
<li onclick="redirectToServlet()">Bookings</li>
<li>Records</li>
<li>Welcome ${username}</li>
</ul>
</nav>
<h1>Admin Page</h1>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
%>
<form action = "Logout">
<input type = "submit" value = "Logout">
</form>
</body>
</html>