package com.example.fareshare.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Update;

import com.example.fareshare.data.entities.wrappers.Address;
@Entity
public class Request {

    @PrimaryKey
    @ColumnInfo(name = "request_id")
    private Long requestID;
    @Embedded(prefix = "pickup_") private Address pickup;
    @Embedded(prefix = "destination_") private Address destination;
    private String filter;

    public Request() {}

    @Ignore
    public Request(Address pickup, Address destination, String filter) {
        this.pickup = pickup;
        this.destination = destination;
        this.filter = filter;
    }

    public Long getRequestID() {
        return requestID;
    }

    public void setRequestID(Long requestID) {
        this.requestID = requestID;
    }

    public Address getPickup() {
        return pickup;
    }

    public void setPickup(Address pickup) {
        this.pickup = pickup;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
