<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Slot</title>
<link rel="stylesheet" href="style.css">
<script>
  function redirectToServlet() {
      window.location.href = 'UserHome.jsp'; 
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
<li onclick = "redirectToServlet()">Home Page</li>
<li onclick = "redirectToServlet2()">Records</li>
<li>Welcome ${username}</li>
<li onclick="redirectToServlet3()">End</li>
</ul>
</nav>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
%>
<h1>Book Slots</h1>
${username}
${mechanicAvailability}
${mechanicCount}
	<form action="Complaint" method ="post">
	Enter Vehicle Number:<input type ="number" name="car_number"><br>
	Enter Make of Car:<input type ="text" name="car_make"><br>
	Enter Model of Car:<input type ="text" name="car_model"><br>
	Enter year of Car:<input type ="number" name="car_year"><br>
	<input type="submit" value ="Book">
	</form>
</body>
</html>