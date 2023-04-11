package com.example.fareshare.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.viewmodels.IncidentViewModel;
import com.example.fareshare.R;
import com.example.fareshare.data.entities.Incident;
import com.example.fareshare.databinding.FragmentIncidentBinding;

public class IncidentFragment extends Fragment {

    private FragmentIncidentBinding binding;

    private IncidentViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentIncidentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(IncidentViewModel.class);
        binding.submitIncidentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Incident incident = new Incident(
                        binding.incidentEmailBox.getText().toString(),
                        binding.reportBox.getText().toString());

                try {
                    viewModel.insertIncident(incident);
                } catch (Exception e) {return;}

                NavHostFragment.findNavController(IncidentFragment.this)
                       .navigate(R.id.action_incidentFragment_to_homeFragment);
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IncidentFragment.this)
                        .navigate(R.id.action_incidentFragment_to_homeFragment);
            }
        });
    }
}