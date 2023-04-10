package com.example.fareshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.FragmentEditRequestBinding;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;

import org.w3c.dom.Text;

public class EditRequestFragment extends Fragment {

    private FragmentEditRequestBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    private RequestViewModel requestViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentEditRequestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dispatcherViewModel = new ViewModelProvider(requireActivity()).get(DispatcherViewModel.class);
        Button submitButton = binding.submitEditRequestButton;
        Button cancelButton = binding.cancelButton;
        EditText destination_box = binding.editDestinationBox;
        EditText pickup_box = binding.editPickupBox;
        EditText pickupTime_box = binding.editPickupTimeBox;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Update Request Obj
                // NavHostFragment.findNavController(EditRequestFragment.this)
                //        .navigate(R.id.action_editRequestFragment_to_homeFragment);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavHostFragment.findNavController(EditRequestFragment.this)
                //        .navigate(R.id.action_editRequestFragment_to_homeFragment);
                //TODO: remove request info
            }
        });
    }
}