<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!--ProfileController.java -> profile.jsp-->
<html>
<head>
<title>User Profile</title>
</head>
<body>

    <%
       // Unpacking data from the request object (Scriptlet method)
       String name = (String) request.getAttribute("Uname");
       Integer id = (Integer) request.getAttribute("UId");
       List<String> friends = (List<String>) request.getAttribute("fList");
    %>

    <h1>User Details</h1>
    <hr>
    <h2>Welcome, <%= name %>!</h2>
    <p>Your Unique ID is: <b><%= id %></b></p>

    <h3>Friend List:</h3>
    <ul>
        <%
           if(friends != null) {
               for(String friend : friends) {
        %>
                <li><%= friend %></li>
        <%
               }
           }
        %>
    </ul>

</body>
</html>