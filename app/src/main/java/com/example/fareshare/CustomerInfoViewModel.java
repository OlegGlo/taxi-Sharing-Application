package com.example.fareshare;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fareshare.data.CustomerInfoRepository;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;

import java.util.List;

public class CustomerInfoViewModel extends AndroidViewModel {

    CustomerInfoRepository repository;

    //TODO: Group stuff
    LiveData<List<CustomerInfo>> customerList;

    public CustomerInfoViewModel(Application application) {
        super(application);
        repository = new CustomerInfoRepository(application);
        customerList = repository.getCustomers();
    }

    public LiveData<List<CustomerInfo>> getAllCustomers() {
        return customerList;
    }

    public void insertCustomer(CustomerInfo customerInfo) throws Exception {
        repository.insert(customerInfo);
    }

    public CustomerIdentity getVerificationInfo(String email) {
        return repository.getVerificationInfo(email);
    }
}
