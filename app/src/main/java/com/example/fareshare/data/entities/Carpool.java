package com.example.fareshare.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Carpool {
    @PrimaryKey
    @ColumnInfo(name = "carpool_id")
    private Long carpoolID;
    @ColumnInfo(name = "num_passengers")
    private int numPassengers;
    private ArrayList<Request> requesters;
    private Offer offerer;
    private String destination;
    @ColumnInfo(name = "taxi_id")
    private String taxiID;
    private boolean ongoing;

    public Carpool() {}

    @Ignore
    public Carpool(int numPassengers, ArrayList<Request> requesters, Offer offerer, String destination, String taxiID, boolean ongoing) {
        this.numPassengers = numPassengers;
        this.requesters = requesters;
        this.offerer = offerer;
        this.destination = destination;
        this.taxiID = taxiID;
        this.ongoing = ongoing;
    }

    public Long getCarpoolID() {
        return carpoolID;
    }

    public void setCarpoolID(Long carpoolID) {
        this.carpoolID = carpoolID;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public ArrayList<Request> getRequesters() {
        return requesters;
    }

    public void setRequesters(ArrayList<Request> requesters) {
        this.requesters = requesters;
    }
    public Offer getOfferer() {
        return offerer;
    }
    public void setOfferer(Offer offerer) {
        this.offerer = offerer;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(String taxiID) {
        this.taxiID = taxiID;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }
}
