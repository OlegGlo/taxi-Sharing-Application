package com.example.fareshare.data.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.fareshare.data.entities.CustomerInfo;

@Entity(tableName = "Customer_Identity",
        foreignKeys = @ForeignKey(
                        entity = CustomerInfo.class,
                        parentColumns = "email",
                        childColumns = "email",
                        onDelete = ForeignKey.CASCADE))
public class CustomerIdentity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "email")
    private String email;
    private String password;

    public CustomerIdentity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Ignore
    public boolean verifyUser(String email, String password) {
        return this.email == email && this.password == password;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
