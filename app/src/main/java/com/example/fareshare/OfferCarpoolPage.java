package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.wrappers.Address;
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
    int passenger_int;
    Offer offer;


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
                        .navigateUp();
            }
        });

        binding.offerCarpoolSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickup_string = pickup_address.getText().toString();
                destination_string = destination_address.getText().toString();
                String[] parts = destination_string.split(",");
                String street = parts[0].strip();
                String city = parts[1].strip();
                String province = parts[2].strip();
                String postalCode = parts[3].strip();
                String country = parts[4].strip();
                Address destination = new Address(street, city, province, postalCode, country);
                date_string = date.getText().toString();
                passenger_int = Integer.valueOf(num_passengers.getText().toString());
                String offerer_id = ((Globals) getActivity().getApplication()).getCustomerID();
                offer = new Offer(offerer_id, destination, passenger_int, true);
                ((Globals) getActivity().getApplication()).setOffer(offer);
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
