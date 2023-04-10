package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.OfferCarpoolPageBinding;

public class OfferCarpoolPage extends Fragment {

    private OfferCarpoolPageBinding binding;
    EditText destination_address;
    EditText pickup_address;
    EditText date;
    EditText num_passengers;
    String pickup_string;
    String destination_string;
    String date_string;
    String passenger_string;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = OfferCarpoolPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        destination_address = (EditText) view.findViewById(R.id.offer_carpool_destination_box);
        pickup_address = (EditText) view.findViewById(R.id.offer_carpool_pickup_box);
        date = (EditText) view.findViewById(R.id.offer_carpool_date_box);
        num_passengers = (EditText) view.findViewById(R.id.offer_carpool_numpass_box);

        binding.offerCarpoolCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OfferCarpoolPage.this)
                        .navigate(R.id.action_offerCarpoolPage_to_homeFragment);
            }
        });

        binding.offerCarpoolSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickup_string = pickup_address.getText().toString();
                destination_string = destination_address.getText().toString();
                date_string = date.getText().toString();
                passenger_string = num_passengers.getText().toString();

                // saved these values but not sure how to get them to show on info page
                NavHostFragment.findNavController(OfferCarpoolPage.this)
                        .navigate(R.id.action_offerCarpoolPage_to_scanPage);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
