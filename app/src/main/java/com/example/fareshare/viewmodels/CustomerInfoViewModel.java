package com.example.fareshare.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fareshare.data.CustomerInfoRepository;
import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;

import java.util.List;

public class CustomerInfoViewModel extends AndroidViewModel {

    CustomerInfoRepository repository;

    //TODO: Group stuff
    LiveData<List<CustomerInfo>> customerList;
    LiveData<List<CarpoolGroup>> groupList;

    public CustomerInfoViewModel(Application application) {
        super(application);
        repository = new CustomerInfoRepository(application);
        customerList = repository.getCustomers();
        groupList = repository.getAllGroups();
    }

    public LiveData<List<CustomerInfo>> getAllCustomers() {
        return customerList;
    }

    public CustomerInfo getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public void insertCustomer(CustomerInfo customerInfo) throws Exception {
        repository.insert(customerInfo);
    }

    public CustomerIdentity getVerificationInfo(String email) {
        return repository.getVerificationInfo(email);
    }

    public long addCustomerID(CustomerIdentity customerIdentity) {
        return repository.addCustomerID(customerIdentity);
    }

    public void delete(CustomerIdentity customerIdentity) {
        repository.delete(customerIdentity);
    }

    public void update(CustomerIdentity customerIdentity) {
        repository.update(customerIdentity);
    }

    public CustomerInfo getByID(Long customerID) {
        return repository.getByID(customerID);
    }

    public CustomerInfo getByPhoneNumber(String phoneNumber) {
        return repository.getByPhoneNumber(phoneNumber);
    }

    public void delete(CustomerInfo customerInfo) {
        repository.delete(customerInfo);
    }

    public long addGroup(CarpoolGroup carpoolGroup) {
        return repository.addGroup(carpoolGroup);
    }

    public void delete(CarpoolGroup carpoolGroup) {
        repository.delete(carpoolGroup);
    }

    public CarpoolGroup getGroup(int groupID) {
        return repository.getGroup(groupID);
    }

    public LiveData<List<CarpoolGroup>> getAllGroups() {return groupList;}
}
