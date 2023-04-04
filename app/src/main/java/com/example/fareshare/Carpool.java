package com.example.fareshare;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Carpool {

    int numPassengers;
    List<String> passengers;
    String destination;
    String taxiID;
    boolean ongoing;

    public Carpool() {

    }

    public void addCarpool(int numPassengers, List<String> passengers, String destination, String taxiID, boolean ongoing) {
        this.numPassengers = numPassengers;
        this.passengers = passengers;
        this.destination = destination;
        this.taxiID = taxiID;
        this.ongoing = ongoing;
        // add to db
    }

    public void addPassenger(String passenger) {
        this.passengers.add(passenger);
    }

    public List<String> getPassengers() {
        return this.passengers;
    }

    public void deleteCarpool() {
        // remove from db
    }

    public void setStatus(boolean ongoing) {
        this.ongoing = ongoing;
    }

}
