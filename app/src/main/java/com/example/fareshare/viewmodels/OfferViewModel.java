package com.example.fareshare.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;

import java.util.List;

public class OfferViewModel extends ViewModel  {

    private CustomerInfo customer;
    private Offer offer;
    private LiveData<List<Request>> requests;

    public LiveData<List<Request>> getRequests() {
        return requests;
    }

    public void setRequests(LiveData<List<Request>> requests) {
        this.requests = requests;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public long getCustomerID() {
        return customer.getCustomerID();
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return offer;
    }

    public long getOfferID() {
        return offer.getOfferID();
    }

}
