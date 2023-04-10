package com.example.fareshare.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fareshare.data.DispatcherRepository;
import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.RequestUpdate;

import java.util.List;

public class DispatcherViewModel extends AndroidViewModel {

    DispatcherRepository repository;

    //TODO: Group stuff
    LiveData<List<Offer>> offerList;
    LiveData<List<Request>> requestList;

    public DispatcherViewModel(Application application) {
        super(application);
        repository = new DispatcherRepository(application);
        offerList = repository.getOffers();
        requestList = repository.getRequests();
    }



    //DATABASE METHODS

    public long addCarpool(Carpool carpool){
        return repository.addCarpool(carpool);
    }

    public void delete(Carpool carpool) {
        repository.delete(carpool);
    }

    public long addOffer(Offer offer) {
        return repository.addOffer(offer);
    }

    public Offer getOffer(int offerID) {
        return repository.getOffer(offerID);
    }

    public void delete(Offer offer) {
        repository.delete(offer);
    }

    public LiveData<List<Offer>> getOffers() {
        return offerList;
    }

    public LiveData<List<Request>> getRequests() {
        return requestList;
    }

    public long addRequest(Request request) {
        return repository.addRequest(request);
    }

    public void update(RequestUpdate requestUpdate) {
        repository.update(requestUpdate);
    }

    public Request getRequest(int requestID) {
        return repository.getRequest(requestID);
    }

    public void delete(Request request) {
        repository.delete(request);
    }
}