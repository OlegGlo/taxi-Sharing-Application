package com.example.fareshare.ui.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.databinding.FragmentRequestAcceptedBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;


public class RequestAcceptedFragment extends Fragment {

    private FragmentRequestAcceptedBinding binding;
    private RequestViewModel requestViewModel;
    private DispatcherViewModel dispatcherViewModel;
    private CustomerInfoViewModel customerInfoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRequestAcceptedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView taxiID_view = binding.requestAcceptedTaxiID;
        TextView dest_view = binding.requestAcceptedDest;
        TextView numpass_view = binding.requestAcceptedPassengers;

        Offer offer = requestViewModel.getAccepted_offer();
        Carpool carpool = dispatcherViewModel.getCarpoolFromOffer(offer);

        taxiID_view.setText("TaxiID: " + carpool.getTaxiID());
        dest_view.setText("Destination: " + carpool.getDestination());
        numpass_view.setText("Maximum Passengers: " + carpool.getNumPassengers());

        // This will simulate waiting for a ride to begin, ideally when the ride starts
        // all passengers will be sent to the RideActivity
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //TODO: For now this will take us back to the SessionActivity
        getActivity().finish();
    }

}