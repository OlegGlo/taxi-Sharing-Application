package com.example.fareshare.data;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.fareshare.data.daos.CustomerInfoDao;
import com.example.fareshare.data.databases.CustomerInfoDB;
import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;

import java.util.List;

public class CustomerInfoRepository {

    private CustomerInfoDao customerInfoDao;
    private LiveData<List<CustomerInfo>> allCustomers;
    private LiveData<List<CarpoolGroup>> allGroups;

    public CustomerInfoRepository(Application application) {
        CustomerInfoDB db = CustomerInfoDB.getDatabase(application);
        customerInfoDao = db.customerInfoDao();
        allCustomers = customerInfoDao.getAllCustomers();
        allGroups = customerInfoDao.getAllGroups();
    }

    public LiveData<List<CustomerInfo>> getCustomers() {
        return allCustomers;
    }

    public CustomerInfo getByEmail(String email){
        return customerInfoDao.getByEmail(email);
    }

    public void insert(CustomerInfo customerInfo) throws Exception {
        //new insertAsyncTask(customerInfoDao).execute(customerInfo);
        customerInfoDao.addCustomer(customerInfo);
    }

    public CustomerIdentity getVerificationInfo(String email) {
        return customerInfoDao.getID(email);
    }

    public long addCustomerID(CustomerIdentity customerIdentity) {
        return customerInfoDao.addCustomerID(customerIdentity);
    }

    public void delete(CustomerIdentity customerIdentity) {
        customerInfoDao.delete(customerIdentity);
    }

    public void update(CustomerIdentity customerIdentity) {
        customerInfoDao.update(customerIdentity);
    }

    public CustomerInfo getByID(Long customerID) {
        return customerInfoDao.getByID(customerID);
    }

    public CustomerInfo getByPhoneNumber(String phoneNumber) {
        return customerInfoDao.getByPhoneNumber(phoneNumber);
    }

    public void delete(CustomerInfo customerInfo) {
        customerInfoDao.delete(customerInfo);
    }

    public long addGroup(CarpoolGroup carpoolGroup) {
        return customerInfoDao.addGroup(carpoolGroup);
    }

    public void delete(CarpoolGroup carpoolGroup) {
        customerInfoDao.delete(carpoolGroup);
    }

    public CarpoolGroup getGroup(int groupID) {
        return customerInfoDao.getGroup(groupID);
    }

    public LiveData<List<CarpoolGroup>> getAllGroups() {return allGroups;}

}
