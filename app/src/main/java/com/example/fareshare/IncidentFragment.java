package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.FragmentIncidentBinding;

import org.w3c.dom.Text;

public class IncidentFragment extends Fragment {

    private FragmentIncidentBinding binding;

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

        Text incidentReport = view.findViewById(R.id.report_box);
        Button submitButton = view.findViewById(R.id.submitIncidentButton);
        Button cancelButton = view.findViewById(R.id.cancelButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IncidentFragment.this)
                       .navigate(R.id.action_incidentFragment_to_homeFragment);
                return;
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavHostFragment.findNavController(IncidentFragment.this)
                //        .navigate(R.id.action_incidentFragment_to_homeFragment);
                return;
            }
        });
    }
}