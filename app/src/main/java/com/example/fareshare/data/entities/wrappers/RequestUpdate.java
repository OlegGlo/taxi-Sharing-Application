package com.example.fareshare.data.entities.wrappers;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;

@Entity
public class RequestUpdate {

    @ColumnInfo(name = "request_id")
    private Long requestID;
    @Embedded(prefix = "pickup_") private Address pickup;
    @Embedded(prefix = "destination_") private Address destination;
    @ColumnInfo(name = "filter")
    private String filter;

    public RequestUpdate(Address pickup, Address destination, String filter) {
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
