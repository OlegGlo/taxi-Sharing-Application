package com.example.fareshare.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.Address;
import com.example.fareshare.data.entities.wrappers.RequestUpdate;

import java.util.List;

@Dao
public interface DispatcherDao{

    //CARPOOL STUFF
    @Insert
    long addCarpool(Carpool carpool);
    @Delete
    void delete(Carpool carpool);

    //OFFER STUFF
    @Insert
    long addOffer(Offer offer);

    @Query("SELECT * FROM Offer WHERE offer_id LIKE :offerID")
    Offer getOffer(int offerID);

    @Query("SELECT * FROM Offer")
    LiveData<List<Offer>> getAllOffers();

    @Delete
    void delete(Offer offer);

    //REQUEST STUFF
    @Insert
    long addRequest(Request request);

    @Update(entity = Request.class)
    void update(RequestUpdate requestUpdate);

    @Query("SELECT * FROM Request")
    LiveData<List<Request>> getAllRequests();

    @Query("SELECT * FROM Request WHERE request_id LIKE :requestID")
    Request getRequest(int requestID);

    @Delete
    void delete(Request request);

}
