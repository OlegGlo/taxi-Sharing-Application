package com.example.fareshare.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.R;

import androidx.lifecycle.ViewModelProvider;

import com.example.fareshare.Globals;
import com.example.fareshare.databinding.FragmentHomeBinding;

import com.example.fareshare.viewmodels.CustomerInfoViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private CustomerInfoViewModel customerInfoViewModel;

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

        customerInfoViewModel = new ViewModelProvider(this).get(CustomerInfoViewModel.class);

        String email = ((Globals) getActivity().getApplication()).getCustomerID();
        String name = customerInfoViewModel.getByEmail(email).getFirstName();
        String newText = binding.welcomeMessage.getText().toString().replace("user",name);
        Log.d("customer-name", name);
        binding.welcomeMessage.setText(newText);

        binding.offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Started Carpool Offer!", Snackbar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_homeFragment_to_offerCarpoolPage);
            }
        });
        binding.requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Started Carpool Request!", Snackbar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_homeFragment_to_requestFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}