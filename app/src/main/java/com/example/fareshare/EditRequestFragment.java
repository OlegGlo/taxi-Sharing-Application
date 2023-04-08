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

import com.example.fareshare.databinding.FragmentEditrequestBinding;

import org.w3c.dom.Text;

public class RequestFragment extends Fragment {

    private FragmentEditrequestBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentEditrequestBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    protected void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button submitButton = (Button) view.findViewById(R.id.submitEditRequestButton);
        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        Text destination = view.findViewById(R.id.edit_destination_box);
        Text pickup = view.findViewById(R.id.edit_pickup_box);
        Text pickupTime = view.findViewById(R.id.edit_pickupTime_box);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Update Request Obj
                NavHostFragment.findNavController(RequestFragment.this)
                        .navigate(R.id.action_editRequestFragment_to_homeFragment);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RequestFragment.this)
                        .navigate(R.id.action_editRequestFragment_to_homeFragment);
            }
        });
    }