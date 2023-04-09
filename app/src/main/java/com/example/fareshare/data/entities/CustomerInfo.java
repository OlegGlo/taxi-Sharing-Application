package com.example.fareshare.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.fareshare.data.entities.wrappers.Address;

@Entity(tableName = "Customers",
        indices = {@Index(value = "phone_number", unique = true)})
public class CustomerInfo {

    @PrimaryKey
    @ColumnInfo(name = "customer_id")
    private long customerID;
    @NonNull
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @Embedded private Address address;
    @NonNull
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;
    @ColumnInfo(name = "ref_profile_picture")
    private String refProfilePicture;
    @ColumnInfo(name = "rating")
    private double rating;

    public CustomerInfo(@NonNull String email, String password, String firstName, String lastName, Address address, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Ignore
    public boolean verifyUser(String email, String password) {
        return this.email == email && this.password == password;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRefProfilePicture() {
        return refProfilePicture;
    }

    public void setRefProfilePicture(String refProfilePicture) {
        this.refProfilePicture = refProfilePicture;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
