package com.example.fareshare;

import android.app.Application;

public class Globals extends Application {

    private String customerID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String someVariable) {
        this.customerID = someVariable;
    }
}
