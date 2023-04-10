package com.example.fareshare.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.fareshare.data.entities.CustomerInfo;

public class SessionViewModel extends ViewModel {

    private CustomerInfo customer;
    private String mfaToken;

    public void setMfaToken(String mfaToken) {
        this.mfaToken = mfaToken;
    }

    public String getMfaToken() {
        return mfaToken;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customer.getFirstName();
    }
}
