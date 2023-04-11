package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.Address;
import com.example.fareshare.databinding.OfferWaitPageBinding;

import java.util.ArrayList;

public class OfferWaitPage extends Fragment {

    private OfferWaitPageBinding binding;
    TextView textView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = OfferWaitPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast toast = Toast.makeText(getContext(), ((Globals) getActivity().getApplication()).getOffer().getTaxiID(), Toast.LENGTH_LONG);
        toast.show();
        binding.startRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Request> requesters = ((Globals) getActivity().getApplication()).getPassengers();
                int num_passengers = 1 + requesters.size();
                Offer offerer = ((Globals) getActivity().getApplication()).getOffer();
                String destination = offerer.getDestination().toString();
                String taxiID = offerer.getTaxiID();
                Carpool carpool = new Carpool(num_passengers, requesters, offerer, destination, taxiID, true);
                NavHostFragment.findNavController(OfferWaitPage.this)
                        .navigate(R.id.action_offerWaitPage_to_carpoolRidePage);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
