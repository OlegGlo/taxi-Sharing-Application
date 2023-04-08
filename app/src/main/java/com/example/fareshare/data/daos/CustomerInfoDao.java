package com.example.fareshare.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.wrappers.FullName;

import java.util.List;

@Dao
public interface CustomerInfoDao {

    @Query("SELECT * FROM Customers")
    LiveData<List<CustomerInfo>> getAllCustomers();

    @Query("SELECT email, password FROM Customers WHERE email LIKE :customerEmail")
    CustomerIdentity getVerificationInfo(String customerEmail);

    @Query("SELECT * FROM CUSTOMERS WHERE email LIKE :customerEmail")
    CustomerInfo getByEmail(String customerEmail);

    @Query("SELECT * FROM CUSTOMERS WHERE phone_number LIKE :phoneNumber")
    CustomerInfo getByPhoneNumber(String phoneNumber);

    @Query("SELECT first_name, last_name FROM Customers WHERE email LIKE :customerEmail")
    FullName getFullName(String customerEmail);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertAll(CustomerInfo...customerInfos) throws Exception;

    @Insert
    void addCustomer(CustomerInfo customerInfo) throws Exception;

    @Delete
    void delete(CustomerInfo customerInfo);
}
