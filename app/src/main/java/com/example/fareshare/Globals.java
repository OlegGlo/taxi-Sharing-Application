package com.example.fareshare;

import android.app.Application;

import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;

import java.util.ArrayList;

public class Globals extends Application {

    private String customerID;
    private String taxiID;
    private Offer offer;
    private ArrayList<Request> incoming = new ArrayList<>();
    private ArrayList<Request> passengers = new ArrayList<>();

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String someVariable) {
        this.customerID = someVariable;
    }

    public String getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(String someVariable) {
        this.taxiID = someVariable;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void addPassenger(Request request) {
        passengers.add(request);
    }

    public ArrayList<Request> getIncoming() {
        return incoming;
    }

    public ArrayList<Request> getPassengers() {
        return passengers;
    }
}
