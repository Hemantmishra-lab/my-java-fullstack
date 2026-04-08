package com.trumio.model;

import java.util.List;

//@ModelAttribute -> Model: FlightBooking.java -> View (Input): booking-form.jsp -> Controller: BookingController.java -> View (Output): ticket-summary.jsp

public class FlightBooking {
    private String passengerName;
    private String passportNumber;
    private String destination;
    private int luggageWeight;
    private List<String> services; // For Extra Meal, Wi-Fi, etc.

    // Default Constructor
    public FlightBooking() {}

    // Getters and Setters
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public int getLuggageWeight() { return luggageWeight; }
    public void setLuggageWeight(int luggageWeight) { this.luggageWeight = luggageWeight; }

    public List<String> getServices() { return services; }
    public void setServices(List<String> services) { this.services = services; }
}