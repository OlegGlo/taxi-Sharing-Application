package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.Address;
import com.example.fareshare.databinding.RequestIncomingPageBinding;

public class RequestIncomingPage extends Fragment {

    private RequestIncomingPageBinding binding;
    private Request request;
//    Address pickup = new Address(street, city, province, postalCode, country);
//    Address destination = new Address(street, city, province, postalCode, country);
//    request = new Request(pickup, destination, filter);
    String firstname = "John";
    String lastname = "Smith";
    double rate = 4.5;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = RequestIncomingPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView name = (TextView) view.findViewById(R.id.request_incoming_name_textview);
        TextView rating = (TextView) view.findViewById(R.id.request_incoming_rating_textview);
        name.setText("Name: " + firstname + " " + lastname);
        rating.setText("Rating: " + String.valueOf(rate) + "/5");

        binding.requestIncomingAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // saved these values but not sure how to get them to show on info page
                ((Globals) getActivity().getApplication()).addPassenger(request);
                NavHostFragment.findNavController(RequestIncomingPage.this)
                        .navigate(R.id.action_requestIncomingPage_to_offerWaitPage);
            }
        });
        binding.requestIncomingRejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // saved these values but not sure how to get them to show on info page
                NavHostFragment.findNavController(RequestIncomingPage.this)
                        .navigate(R.id.action_requestIncomingPage_to_offerWaitPage);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
