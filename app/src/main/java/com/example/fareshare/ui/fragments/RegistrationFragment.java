package com.example.fareshare.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
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

        viewModel = new ViewModelProvider(requireActivity()).get(CustomerInfoViewModel.class);
        binding.registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!binding.password1Box.getText().toString().equals(binding.password2Box.getText().toString())){
                    Snackbar.make(view, "Your passwords don't match.", Snackbar.LENGTH_SHORT).show();
                }

                else if(binding.emailBox.getText() == null) {
                    Snackbar.make(view, "You must enter an email address", Snackbar.LENGTH_SHORT).show();
                }

                else if(binding.phonenumberBox.getText() == null) {
                    Snackbar.make(view, "You must enter an phone number", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Address address = new Address(
                            binding.streetBox.getText().toString(),
                            binding.cityBox.getText().toString(),
                            binding.provinceBox.getText().toString(),
                            binding.postalCodeBox.getText().toString(),
                            binding.countryBox.getText().toString());

                    String birthday = binding.birthdayDay.getText().toString() +
                            binding.birthdayMonth.getText().toString() +
                            binding.birthdayYear.getText().toString();

                    CustomerInfo customer = new CustomerInfo(
                            binding.emailBox.getText().toString(),
                            binding.registerFirstnameBox.getText().toString(),
                            binding.registerLastnameBox.getText().toString(),
                            birthday,
                            address,
                            binding.phonenumberBox.getText().toString());

                    try {
                        viewModel.insertCustomer(customer);

                        CustomerIdentity id = new CustomerIdentity(binding.emailBox.getText().toString(),
                                binding.password2Box.getText().toString());

                        viewModel.addCustomerID(id);
                    } catch (Exception e) {
                        Snackbar.make(view, "Email/phone number already exists.", Snackbar.LENGTH_SHORT).show();
                    }

                    NavHostFragment.findNavController(RegistrationFragment.this)
                            .navigate(R.id.action_registrationFragment_to_loginFragment);
                }
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