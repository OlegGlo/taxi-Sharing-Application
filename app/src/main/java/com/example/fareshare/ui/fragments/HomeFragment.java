package com.example.fareshare.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fareshare.databinding.FragmentHomeBinding;
import com.example.fareshare.ui.activities.RequestActivity;
import com.example.fareshare.ui.activities.SessionActivity;
import com.example.fareshare.viewmodels.SessionViewModel;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SessionViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SessionViewModel.class);
        //String newText = binding.welcomeMessage.getText().toString().replace("user",viewModel.getCustomerName());
        //binding.welcomeMessage.setText(newText);

        binding.offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Started Carpool Offer!", Snackbar.LENGTH_SHORT).show();
            }
        });
        binding.requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Started Carpool Request!", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), RequestActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}