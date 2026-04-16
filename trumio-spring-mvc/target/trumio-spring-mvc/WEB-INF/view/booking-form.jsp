<html>

<!--@ModelAttribute -> Model: FlightBooking.java -> View (Input): booking-form.jsp -> Controller: BookingController.java -> View (Output): ticket-summary.jsp -->

<head><title>SkyHigh Airlines</title></head>
<body>
    <h2>International Flight Booking</h2>
    <form action="confirmBooking" method="POST">
        Passenger Name: <input type="text" name="passengerName"><br><br>
        Passport No: <input type="text" name="passportNumber"><br><br>

        Destination:
        <select name="destination">
            <option value="New York">New York</option>
            <option value="London">London</option>
            <option value="Tokyo">Tokyo</option>
        </select><br><br>

        Luggage (kg): <input type="number" name="luggageWeight"><br><br>

        Add-on Services:<br>
        <input type="checkbox" name="services" value="In-flight Meal"> Extra Meal
        <input type="checkbox" name="services" value="Priority Boarding"> Priority Boarding
        <input type="checkbox" name="services" value="Extra Legroom"> Extra Legroom
        <br><br>

        <button type="submit">Book Flight</button>
    </form>
</body>
</html>