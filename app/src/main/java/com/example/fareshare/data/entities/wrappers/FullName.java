package com.example.fareshare.data.entities.wrappers;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class FullName {

    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    @NonNull
    private String lastName;

    public FullName(String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
