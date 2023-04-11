package com.example.fareshare.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fareshare.R;
import com.example.fareshare.databinding.FragmentRequestRejectedBinding;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;


public class RequestRejectedFragment extends Fragment {

    private FragmentRequestRejectedBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    private RequestViewModel requestViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRequestRejectedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button backButton = binding.requestRejectedBackButton;
        Button cancelButton = binding.requestRejectedCancelButton;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RequestRejectedFragment.this)
                        .navigate(R.id.action_requestRejectedFragment_to_requestSelectFragment);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatcherViewModel.delete(requestViewModel.getRequest());
                getActivity().finish();
            }
        });
    }
}