<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Job </title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Assign Job Admin Page</h1>
<form action = "SetJob" method ="post">
    <h2>Select Car Number</h2>
    <select name="carNumberDropdown">
        <% 
        List<Integer> carNumbers = (List<Integer>) request.getAttribute("carNumbers");
        for (int carNumber : carNumbers) {
            %>
            <option value="<%= carNumber %>"><%= carNumber %></option>
            <%
        }
        %>
    </select>

    <h2>Select Mechanic ID</h2>
    <select name="mechanicIdDropdown">
        <% 
        List<Integer> mechanicIds = (List<Integer>) request.getAttribute("mechanicIds");
        for (int mechanicId : mechanicIds) {
            %>
            <option value="<%= mechanicId %>"><%= mechanicId %></option>
            <%
        }
        %>
    </select>
    <input type = "submit" value ="Assign Job">
</form>
</body>
</html>