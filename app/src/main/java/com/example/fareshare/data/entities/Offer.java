package com.example.fareshare.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.fareshare.data.entities.wrappers.Address;

@Entity
public class Offer {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "offer_id")
    private Long offerID;
    private String offerer;
    @Embedded private Address destination;
    @ColumnInfo(name = "max_passengers")
    private int maxPassengers;
    private boolean open;
    private String taxiID;

    public Offer(){}

    @Ignore
    public Offer(String offerer, Address destination, int maxPassengers, boolean open) {
        this.offerer = offerer;
        this.destination = destination;
        this.maxPassengers = maxPassengers;
        this.open = open;
        this.taxiID = null;
    }

    public String getOfferer() {
        return offerer;
    }

    public void setOfferer(String offerer) {
        this.offerer = offerer;
    }

    public Long getOfferID() {
        return offerID;
    }

    public void setOfferID(Long offerID) {
        this.offerID = offerID;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    public String getTaxiID() {
        return taxiID;
    }
    public void setTaxiID(String taxiID) {
        this.taxiID = taxiID;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
