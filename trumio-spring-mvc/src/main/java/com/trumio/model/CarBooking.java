package com.trumio.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "car")
public class CarBooking {
    private String passengerName;
    @Id
    private int passengerNumber;
    private String finalDestination;
    @ElementCollection
    @CollectionTable(name = "visit-Places", joinColumns = @JoinColumn(name = "Car-Passenger_id"))
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