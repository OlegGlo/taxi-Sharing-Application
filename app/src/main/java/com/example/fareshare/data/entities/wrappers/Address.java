package com.example.fareshare.data.entities.wrappers;

import android.provider.Telephony;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

public class Address {
    private String street;
    private String city;
    private String province;
    @ColumnInfo(name = "postal_code")
    private String postalCode;
    private String country;

    public Address(String street, String city, String province, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Ignore
    public String toString(){
        return street + "\n" + postalCode + "\n" + city + ", " + province + "\n" + country;
    }
}
