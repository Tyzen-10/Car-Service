<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fast Car Care</title>
<link rel="stylesheet" href="style.css">
  <script>
  function redirectToServlet() {
      window.location.href = 'Book'; 
  }
  function redirectToServlet2(){
	  window.location.href = 'ViewRep';
  }
  function redirectToServlet3(){
	  window.location.href = "Logout"
  }
  </script>
</head>
<body>
<nav>
<ul>
<li onclick="redirectToServlet()">Book Slot</li>
<li onclick="redirectToServlet2()">View Reports</li>
<li>Welcome ${username}</li>
<li onclick="redirectToServlet3()">End</li>
</ul>
</nav>
<h1 style = text-align:center>User Home page</h1>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
%>
Welcome ${username}
<form action = "Logout">
<input type = "submit" value = "Logout">
</form>
</body>
</html>