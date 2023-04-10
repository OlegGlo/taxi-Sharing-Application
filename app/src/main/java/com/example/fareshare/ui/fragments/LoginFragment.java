package com.example.fareshare.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.R;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.databinding.FragmentLoginBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private CustomerInfoViewModel CIViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CIViewModel = new ViewModelProvider(requireActivity()).get(CustomerInfoViewModel.class);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailUsername.getText().toString();
                String password = binding.password.getText().toString();
                CustomerIdentity id = CIViewModel.getVerificationInfo(email);

                if (email.equals("admin") && password.equals("1234")) {
                    Snackbar.make(view, "Admin Login", Snackbar.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(LoginFragment.this)
                            .navigate(R.id.action_loginFragment_to_authenticatorFragment);
                } else if(id == null){
                    Snackbar.make(view, "There is no account associated with that email.", Snackbar.LENGTH_SHORT).show();
                } else if (email.equals(id.getEmail()) && password.equals(id.getPassword())) {
                    Snackbar.make(view, "Login Successful!", Snackbar.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(LoginFragment.this)
                            .navigate(R.id.action_loginFragment_to_authenticatorFragment);
                } else {
                    Snackbar.make(view, "Incorrect password", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        binding.signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.registrationFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
