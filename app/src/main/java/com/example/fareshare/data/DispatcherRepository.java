package com.example.fareshare.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.fareshare.data.daos.DispatcherDao;
import com.example.fareshare.data.databases.DIspatcherDB;
import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.RequestUpdate;

import java.util.List;

public class DispatcherRepository {

    private DispatcherDao dispatcherDao;
    private LiveData<List<Offer>> allOffers;
    private LiveData<List<Request>> allRequests;

    public DispatcherRepository(Application application) {
        DIspatcherDB db = DIspatcherDB.getDatabase(application);
        dispatcherDao = db.dispatcherDao();
        allOffers = dispatcherDao.getAllOffers();
        allRequests = dispatcherDao.getAllRequests();
    }

    public long addCarpool(Carpool carpool){
        return dispatcherDao.addCarpool(carpool);
    }

    public void delete(Carpool carpool) {
        dispatcherDao.delete(carpool);
    }

    public long addOffer(Offer offer) {
        return dispatcherDao.addOffer(offer);
    }

    public Offer getOffer(int offerID) {
        return dispatcherDao.getOffer(offerID);
    }

    public void delete(Offer offer) {
        dispatcherDao.delete(offer);
    }

    public LiveData<List<Offer>> getOffers() {
        return allOffers;
    }

    public LiveData<List<Request>> getRequests() {
        return allRequests;
    }

    public long addRequest(Request request) {
        return dispatcherDao.addRequest(request);
    }

    public void update(RequestUpdate requestUpdate) {
        dispatcherDao.update(requestUpdate);
    }

    public Request getRequest(int requestID) {
        return dispatcherDao.getRequest(requestID);
    }

    public void delete(Request request) {
        dispatcherDao.delete(request);
    }
}
