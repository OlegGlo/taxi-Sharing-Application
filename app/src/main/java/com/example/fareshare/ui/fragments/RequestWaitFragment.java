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
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.databinding.FragmentRequestWaitBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class RequestWaitFragment extends Fragment {

    private FragmentRequestWaitBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    private CustomerInfoViewModel customerInfoViewModel;
    private RequestViewModel requestViewModel;
    private List<Offer> finalOffers;
    private Request request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRequestWaitBinding.inflate(inflater, container, false);
        request = requestViewModel.getRequest();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        waitForOffers(view);
        requestViewModel.setOffers(finalOffers);
        NavHostFragment.findNavController(RequestWaitFragment.this)
                .navigate(R.id.action_requestWaitFragment_to_requestSelectFragment);
    }

    public void waitForOffers(View view) {
        Snackbar.make(view, "Loading...", Snackbar.LENGTH_SHORT).show(); // temp
        List<Offer> offers = dispatcherViewModel.getOffers().getValue();
        for (Offer offer : offers) {
            if (offer.getDestination().equals(request.getDestination())) {
                if (offer.getMaxPassengers() == Integer.parseInt(request.getFilter())) {
                    finalOffers.add(offer);
                }
            }
        }
    }
}