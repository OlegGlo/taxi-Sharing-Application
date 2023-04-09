package com.example.fareshare.data;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.fareshare.data.daos.CustomerInfoDao;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;

import java.util.List;

public class CustomerInfoRepository {

    //TODO: Group stuff

    private CustomerInfoDao customerInfoDao;
    private LiveData<List<CustomerInfo>> allCustomers;

    public CustomerInfoRepository(Application application) {
        CustomerInfoDB db = CustomerInfoDB.getDatabase(application);
        customerInfoDao = db.customerInfoDao();
        allCustomers = customerInfoDao.getAllCustomers();
    }

    public LiveData<List<CustomerInfo>> getCustomers() {
        return allCustomers;
    }

    public void insert(CustomerInfo customerInfo) throws Exception {
        //new insertAsyncTask(customerInfoDao).execute(customerInfo);
        customerInfoDao.addCustomer(customerInfo);
    }

    public CustomerIdentity getVerificationInfo(String email) {
        return customerInfoDao.getVerificationInfo(email);
    }

//    private static class insertAsyncTask extends AsyncTask<CustomerInfo,Void,Void> {
//        private CustomerInfoDao taskDao;
//
//        insertAsyncTask(CustomerInfoDao customerInfoDao) {
//            taskDao = customerInfoDao;
//        }
//
//        @Override
//        protected Void doInBackground(CustomerInfo... customerInfos) {
//            try {
//                taskDao.insertAll(customerInfos[0]);
//            } catch (Exception e) {
//
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//
//        }
//    }
}
