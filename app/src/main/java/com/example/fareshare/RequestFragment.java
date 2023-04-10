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

import androidx.annotation.Discouraged;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.data.entities.Request;
import com.example.fareshare.databinding.FragmentRequestBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;

import org.w3c.dom.Text;

public class RequestFragment extends Fragment {

    private FragmentRequestBinding binding;
    private DispatcherViewModel dispatcherViewModel;
    //private NavHostFragment navHostFragment;


//    public RequestFragment() {
//        // Blank constructor required?
//    }

//    public static RequestFragment newInstance() {
//        RequestFragment fragment = new RequestFragment();
//        return fragment;
//    }
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

        dispatcherViewModel = new ViewModelProvider(requireActivity()).get(DispatcherViewModel.class);

        Button submitButton = binding.submitRequestButton;
        Button cancelButton = binding.cancelButton;
        EditText destination_box = binding.destinationBox;
        EditText pickup_box = binding.pickupBox;
        EditText pickupTime_box = binding.pickupTimeBox;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: update request obj
                // NavHostFragment.findNavController(RequestFragment.this)
                //        .navigate(R.id.action_requestFragment_to_homeFragment);
                String destination = destination_box.getText().toString();
                String pickup = pickup_box.getText().toString();
                //TODO: Current request object doesn't have time, I just assumed ASAP, can be added though
                String pickupTime = pickupTime_box.getText().toString();

                //Request request = new Request()

            }

        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 getActivity().finish();
            }
        });
    }
}