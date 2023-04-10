package com.example.fareshare.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.databinding.FragmentRequestWaitBinding;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class RequestWaitFragment extends Fragment {

    private FragmentRequestWaitBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    private RequestViewModel requestViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRequestWaitBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        waitForOffers(view);
        // TODO: Navigate to offer selection page
    }

    public void waitForOffers(View view) {
        // TODO: will loop until there is at least one offer
        Snackbar.make(view, "Started Carpool Offer!", Snackbar.LENGTH_SHORT).show(); // temp
    }
}