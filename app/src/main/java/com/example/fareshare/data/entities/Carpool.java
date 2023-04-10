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
    private ArrayList<CustomerInfo> passengers;
    private String destination;
    @ColumnInfo(name = "taxi_id")
    private String taxiID;
    private boolean ongoing;

    public Carpool() {}

    @Ignore
    public Carpool(int numPassengers, ArrayList<CustomerInfo> passengers, String destination, String taxiID, boolean ongoing) {
        this.numPassengers = numPassengers;
        this.passengers = passengers;
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

    public ArrayList<CustomerInfo> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<CustomerInfo> passengers) {
        this.passengers = passengers;
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
