<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mechanic Home Page</title>
<link rel="stylesheet" href="style.css">
  <script>
  function redirectToServlet() {
      window.location.href = 'Report'; 
  }
  </script>
</head>
<body>
<nav>
<ul>
<li onclick="redirectToServlet()">Reports</li>
<li>Records</li>
<li>Welcome ${username}</li>
</ul>
</nav>
<h1>Mechanic Home Page</h1>
</body>
</html>