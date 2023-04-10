package com.example.fareshare.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;

import java.util.List;

@Dao
public interface CustomerInfoDao {

    //IDENTITY STUFF
    @Insert
    long addCustomerID(CustomerIdentity customerIdentity);
    @Delete
    void delete(CustomerIdentity customerIdentity);

    @Query("SELECT * FROM Customer_Identity WHERE email LIKE :email")
    CustomerIdentity getID(String email);

    @Update
    void update(CustomerIdentity customerIdentity);

    //CUSTOMER STUFF
    @Query("SELECT * FROM Customers")
    LiveData<List<CustomerInfo>> getAllCustomers();

    @Query("SELECT * FROM CUSTOMERS WHERE customer_id LIKE :customerID")
    CustomerInfo getByID(Long customerID);

    @Query("SELECT * FROM CUSTOMERS WHERE email LIKE :customerEmail")
    CustomerInfo getByEmail(String customerEmail);

    @Query("SELECT * FROM CUSTOMERS WHERE phone_number LIKE :phoneNumber")
    CustomerInfo getByPhoneNumber(String phoneNumber);

    @Insert(entity = CustomerInfo.class)
    long addCustomer(CustomerInfo customerInfo) throws Exception;

    @Delete
    void delete(CustomerInfo customerInfo);

    //GROUP STUFF
    @Insert
    long addGroup(CarpoolGroup carpoolGroup);
    @Delete
    void delete(CarpoolGroup carpoolGroup);

    @Query("SELECT * FROM CarpoolGroup WHERE group_id LIKE :groupID")
    CarpoolGroup getGroup(int groupID);

    @Query("SELECT * FROM CarpoolGroup")
    LiveData<List<CarpoolGroup>> getAllGroups();

}
