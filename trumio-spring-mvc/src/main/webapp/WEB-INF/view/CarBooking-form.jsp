<html>
<head><title>Ghost Car Drive</title></head>
<body>
    <h2>Ride Anywhere, Go Anywhere</h2>

    <form action="Cnf-Booking" method="POST">
        Passenger Name: <input type="text" name="passengerName" /><br><br>

        Passenger Number: <input type="number" name="passengerNumber"/><br><br>

        Final Destination:
        <select name="finalDestination">
            <option value="New Delhi">New Delhi</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Rajasthan">Rajasthan</option>
        </select><br><br>

        Visit Places: <br>
        <input type="checkbox" name="visitPlaces" value="India Gate">India Gate
        <input type="checkbox" name="visitPlaces" value="Taj Hotel">Taj Hotel
        <input type="checkbox" name="visitPlaces" value="Hawa Mahal">Hawa Mahal
        <br><br>

        <button type="submit">Book Car</button>
    </form>
</body>
</html>