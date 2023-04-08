package com.example.fareshare.data.entities;


public class CustomerIdentity {
    private String email;
    private String password;

    public CustomerIdentity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
