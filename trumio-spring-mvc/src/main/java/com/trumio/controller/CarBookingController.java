package com.trumio.controller;

import com.trumio.model.CarBooking;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarBookingController {

    @RequestMapping("/Booking-Car")
    public String showCarBookingForm() {
        return "CarBooking-form";
    }

    @RequestMapping(path = "/Cnf-Booking", method = RequestMethod.POST)
    public String processCarBooking(@ModelAttribute("booking") CarBooking carBooking) {
        // Data is now bound to carBooking object
        return "Cnf-CarBookingSummary";
    }
}