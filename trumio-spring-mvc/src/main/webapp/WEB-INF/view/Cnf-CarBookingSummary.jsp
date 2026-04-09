<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { border: 1px solid #ccc; padding: 20px; width: 400px; border-radius: 8px; }
        h2 { color: #2c3e50; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Booking Confirmed!</h2>
        <hr>

        <p><strong>Passenger Name:</strong> ${booking.passengerName}</p>
        <p><strong>Total Passengers:</strong> ${booking.passengerNumber}</p>
        <p><strong>Final Destination:</strong> ${booking.finalDestination}</p>

        <p><strong>Places to Visit:</strong></p>
        <ul>
            <c:forEach var="place" items="${booking.visitPlaces}">
                <li>${place}</li>
            </c:forEach>
        </ul>

        <br>
        <a href="Booking-Car">Go Back to Home</a>
    </div>

</body>
</html>