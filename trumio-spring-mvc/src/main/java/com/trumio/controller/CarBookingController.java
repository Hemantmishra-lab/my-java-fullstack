package com.trumio.controller;

import com.trumio.Service.CarService;
import com.trumio.model.CarBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarBookingController {

    @Autowired
    private CarService carService;
    @RequestMapping("/Booking-Car")
    public String showCarBookingForm() {
        return "CarBooking-form";
    }

    @RequestMapping(path = "/Cnf-Booking", method = RequestMethod.POST)
    public String processCarBooking(@ModelAttribute("booking") CarBooking carBooking) {
        // Data is now bound to carBooking object
        carService.registerCar(carBooking);
        return "Cnf-CarBookingSummary";
    }
}