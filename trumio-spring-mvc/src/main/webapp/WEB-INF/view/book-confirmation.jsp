<!--//Model Class: Book.java (Fields: title, author, isbn, Volumes) -> Controller: BookController.java -> View (Input): add-book-form.jsp -> View (Output): book-confirmation.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
</head>
<body>
    <div style="border: 1px solid black; padding: 20px; width: 300px;">
        <h2>Book Confirmed!</h2>
        <hr>
        <p><strong>Title:</strong> ${bk.title}</p>
        <p><strong>Author:</strong> ${bk.author}</p>
        <p><strong>ISBN:</strong> ${bk.isbn}</p>

        <p><strong>Selected Volumes:</strong></p>
        <ul>
            <c:forEach var="v" items="${bk.volumes}">
                <li>${v}</li>
            </c:forEach>
        </ul>

        <br>
        <a href="bookBooking">Add Another Book</a>
    </div>
</body>
</html>