package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.FragmentRequestBinding;

import org.w3c.dom.Text;

public class RequestFragment extends Fragment {

    private FragmentRequestBinding binding;
    private NavHostFragment navHostFragment;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRequestBinding.inflate(inflater, container, false);
        // navHostFragment =
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button submitButton = (Button) view.findViewById(R.id.submitRequestButton);
        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        EditText destination_box = view.findViewById(R.id.destination_box);
        EditText pickup_box = view.findViewById(R.id.pickup_box);
        EditText pickupTime_box = view.findViewById(R.id.pickupTime_box);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: update request obj
                // NavHostFragment.findNavController(RequestFragment.this)
                //        .navigate(R.id.action_requestFragment_to_homeFragment);
                String destination = destination_box.getText().toString();
                String pickup = pickup_box.getText().toString();
                String pickupTime = pickupTime_box.getText().toString();


            }

        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavHostFragment.findNavController(RequestFragment.this)
                //        .navigate(R.id.action_requestFragment_to_homeFragment);
                return;
            }
        });
    }
}