<html>

<!--@ModelAttribute -> Model: FlightBooking.java -> View (Input): booking-form.jsp -> Controller: BookingController.java -> View (Output): ticket-summary.jsp -->

<body style="font-family: Arial;">
    <div style="border: 2px dashed black; padding: 20px; width: 400px;">
        <h1 style="color: navy;">E-TICKET SUMMARY</h1>
        <hr>
        <p><strong>Passenger:</strong> ${booking.passengerName}</p>
        <p><strong>Passport:</strong> ${booking.passportNumber}</p>
        <p><strong>Destination:</strong> ${booking.destination}</p>
        <p><strong>Luggage Allowed:</strong> ${booking.luggageWeight} kg</p>
        <p><strong>Add-ons:</strong> ${booking.services}</p>
        <hr>
        <p><i>Have a safe flight!</i></p>
    </div>
    <br>
    <a href="book">New Booking</a>
</body>
</html>