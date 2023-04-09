package com.example.fareshare.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Taxi {

    @PrimaryKey
    @NonNull
    private String taxiID;
    private int capacity;
    private boolean isAvailable = true;

    public Taxi(@NonNull String taxiID, int capacity) {
        this.taxiID = taxiID;
        this.capacity = capacity;
    }

    public void setTaxiID(String taxiID) {
        this.taxiID = taxiID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
