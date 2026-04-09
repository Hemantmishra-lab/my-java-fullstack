package com.trumio.model;

import java.util.List;

public class CarBooking {
    private String passengerName;
    private int passengerNumber;
    private String finalDestination;
    private List<String> visitPlaces;

    public CarBooking() {}

    // Getters and Setters
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public int getPassengerNumber() { return passengerNumber; }
    public void setPassengerNumber(int passengerNumber) { this.passengerNumber = passengerNumber; }

    public String getFinalDestination() { return finalDestination; }
    public void setFinalDestination(String finalDestination) { this.finalDestination = finalDestination; }

    public List<String> getVisitPlaces() { return visitPlaces; }
    public void setVisitPlaces(List<String> visitPlaces) { this.visitPlaces = visitPlaces; }
}