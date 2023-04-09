package com.example.fareshare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.CustomerInfoViewModel;
import com.example.fareshare.R;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.wrappers.Address;
import com.example.fareshare.databinding.FragmentRegistrationBinding;
import com.google.android.material.snackbar.Snackbar;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;
    private CustomerInfoViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(getActivity()).get(CustomerInfoViewModel.class);
        binding.registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Address address = new Address(
                        binding.streetBox.getText().toString(),
                        binding.cityBox.getText().toString(),
                        binding.provinceBox.getText().toString(),
                        binding.postalCodeBox.getText().toString(),
                        binding.countryBox.getText().toString());

                CustomerInfo customer = new CustomerInfo(
                        binding.emailBox.getText().toString(),
                        binding.password2Box.getText().toString(),
                        binding.registerFirstnameBox.getText().toString(),
                        binding.registerLastnameBox.getText().toString(),
                        address,
                        binding.phonenumberBox.getText().toString());

                try {
                    viewModel.insertCustomer(customer);
                } catch (Exception e) {
                    Snackbar.make(view, "Email/phone number already exists.", Snackbar.LENGTH_SHORT).show();
                }

                NavHostFragment.findNavController(RegistrationFragment.this)
                        .navigate(R.id.action_registrationFragment_to_loginFragment);
            }
        });
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegistrationFragment.this)
                        .navigate(R.id.action_registrationFragment_to_loginFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}