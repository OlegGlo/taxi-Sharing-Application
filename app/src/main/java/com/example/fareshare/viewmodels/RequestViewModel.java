package com.example.fareshare.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;

import java.util.List;

public class RequestViewModel extends ViewModel  {

    private CustomerInfo customer;
    private Request request;
    private LiveData<List<Offer>> offers;

    public LiveData<List<Offer>> getOffers() {
        return offers;
    }

    public void setOffers(LiveData<List<Offer>> offers) {
        this.offers = offers;
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

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public long getRequestID() {
        return request.getRequestID();
    }

}
