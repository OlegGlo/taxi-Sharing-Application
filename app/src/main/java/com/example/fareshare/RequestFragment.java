package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.FragmentRequestBinding;

import org.w3c.dom.Text;

public class RequestFragment extends Fragment {

    private FragmentRequestBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRequestBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    protected void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button submitButton = (Button) view.findViewById(R.id.submitRequestButton);
        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        Text destination = view.findViewById(R.id.destination_box);
        Text pickup = view.findViewById(R.id.pickup_box);
        Text pickupTime = view.findViewById(R.id.pickupTime_box);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: update request obj
                NavHostFragment.findNavController(RequestFragment.this)
                        .navigate(R.id.action_requestFragment_to_homeFragment);
            }

        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RequestFragment.this)
                        .navigate(R.id.action_requestFragment_to_homeFragment);
            }
        });
    }