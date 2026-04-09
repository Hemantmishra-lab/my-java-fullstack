package com.trumio.controller;

import com.trumio.model.FlightBooking;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@ModelAttribute -> Model: FlightBooking.java -> View (Input): booking-form.jsp -> Controller: BookingController.java -> View (Output): ticket-summary.jsp

@Controller
public class BookingController {

    // Shows the empty booking form
    @RequestMapping("/book")
    public String showBookingForm() {
        return "booking-form";
    }

        // Handles form submission using @ModelAttribute
    @RequestMapping(path = "/confirmBooking", method = RequestMethod.POST)
    public String processBooking(@ModelAttribute("booking") FlightBooking flightData) {

        // Spring has already populated 'flightData' with all JSP inputs
        // It also automatically adds 'flightData' to the Model as "booking"

        return "ticket-summary";
    }
}