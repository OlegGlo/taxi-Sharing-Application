package com.example.fareshare.data.entities.wrappers;

import com.example.fareshare.data.entities.wrappers.Address;

public class Request {

    private Address pickupLocation;
    private String ratingCriteria;
    private String maxPassengersCriteria;

    public Request(Address pickupLocation, String ratingCriteria, String maxPassengersCriteria) {
        this.pickupLocation = pickupLocation;
        this.ratingCriteria = ratingCriteria;
        this.maxPassengersCriteria = maxPassengersCriteria;
    }
}
