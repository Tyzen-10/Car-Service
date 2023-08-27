<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gmail.wenkatesan.View" %>
<%@ page import="java.util.*" %>

    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Page - USER</title>
<link rel="stylesheet" href="style.css">
<script>
  function redirectToServlet() {
      window.location.href = 'UserHome.jsp'; 
  }
  function redirectToServlet2(){
	  window.location.href = 'Book';
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
<li onclick = "redirectToServlet2()">Book Service</li>
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
	<h1>Report List</h1>

    <% 
    List<View> viewList = (List<View>) request.getAttribute("viewList");
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (errorMessage != null) {
        out.println("<p style='color: red;'>" + errorMessage + "</p>");
    } else if (viewList != null && !viewList.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>Report ID</th>
                <th>Report Content</th>
                <th>Owner Name</th>
            </tr>
            <% for (View view : viewList) { %>
                <tr>
                    <td><%= view.getId() %></td>
                    <td><%= view.getOwnerName() %></td>
                    <td><%= view.getReportContent() %></td>
                </tr>
            <% } %>
        </table>
    <% } else { %>
        <p>No records found.</p>
    <% } %>
</body>
</html>