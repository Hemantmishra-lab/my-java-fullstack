<!--//Model Class: Book.java (Fields: title, author, isbn, Volumes) -> Controller: BookController.java -> View (Input): add-book-form.jsp -> View (Output): book-confirmation.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Booking Form</title>
</head>
<body>
    <h2>Book Booking Form</h2>
    <form action="processBookingbook" method="POST">
        Title: <input type="text" name="sTitle" required><br><br>
        Author: <input type="text" name="sAuthor" required><br><br>
        ISBN: <input type="number" name="sISBN" required><br><br>

        <label>Select Volumes:</label><br>
        <input type="checkbox" name="sVolume" value="Volume Alpha"> Volume Alpha<br>
        <input type="checkbox" name="sVolume" value="Volume Beta"> Volume Beta<br>
        <input type="checkbox" name="sVolume" value="Volume Gamma"> Volume Gamma<br>
        <input type="checkbox" name="sVolume" value="Volume Delta"> Volume Delta<br>
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>