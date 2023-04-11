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

import com.example.fareshare.data.entities.Request;
import com.example.fareshare.data.entities.wrappers.Address;
import com.example.fareshare.data.entities.wrappers.RequestUpdate;
import com.example.fareshare.databinding.FragmentEditRequestBinding;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.Random;

public class EditRequestFragment extends Fragment {

    private FragmentEditRequestBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    private RequestViewModel requestViewModel;
    private Request request;

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
        EditText maxPass_box = binding.editPickupTimeBox;

        Random rand = new Random();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destination = destination_box.getText().toString();
                String pickup = pickup_box.getText().toString();
                String maxPass = maxPass_box.getText().toString();

                String[] p_addr = pickup.split(",");
                String[] d_addr = destination.split(",");

                if ((p_addr.length == 5)&&(d_addr.length == 5)) {

                    Address pickup_addr = new Address(p_addr[0], p_addr[1], p_addr[2], p_addr[3], p_addr[4]);
                    Address destination_addr = new Address(d_addr[0], d_addr[1], d_addr[2], d_addr[3], d_addr[4]);
                    RequestUpdate request = new RequestUpdate(pickup_addr, destination_addr, maxPass);
                    Request request_copy = new Request(pickup_addr, destination_addr, maxPass);
                    request.setRequestID(rand.nextLong());

                    requestViewModel.setRequest(request_copy);
                    dispatcherViewModel.update(request);

                    NavHostFragment.findNavController(EditRequestFragment.this)
                            .navigate(R.id.action_requestFragment_to_requestWaitFragment);

                } else {
                    Snackbar.make(view, "Invalid Inputs", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cancels the edit, return to search/wait
                NavHostFragment.findNavController(EditRequestFragment.this)
                        .navigate(R.id.action_editRequestFragment_to_requestWaitFragment);
            }
        });
    }
}