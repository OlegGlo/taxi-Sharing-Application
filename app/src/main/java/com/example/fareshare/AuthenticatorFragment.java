package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.FragmentAuthenticatorBinding;
import com.google.android.material.snackbar.Snackbar;

public class AuthenticatorFragment extends Fragment {

    private FragmentAuthenticatorBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAuthenticatorBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AuthenticatorFragment.this)
                        .navigate(R.id.action_authenticatorFragment_to_loginFragment);
            }
        });

        binding.verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.token.getText().toString().equals("123456")) {
                    Snackbar.make(view, "Authentication Successful!", Snackbar.LENGTH_SHORT).show();
                    switchToHomeActivity();
                } else {
                    Snackbar.make(view, "Authentication Failed!", Snackbar.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void switchToHomeActivity() {
        Intent intent = new Intent(getActivity().getBaseContext(), SessionActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}