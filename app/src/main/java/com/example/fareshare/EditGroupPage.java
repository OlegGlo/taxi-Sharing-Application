package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.EditGroupPageBinding;

public class EditGroupPage extends Fragment {

    private EditGroupPageBinding binding;
    EditText phone_number;
    EditText pickup_address;
    EditText destination_address;
    String pNum;
    String pAdd;
    String dAdd;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = EditGroupPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phone_number = (EditText) view.findViewById(R.id.editTextPhone);
        pickup_address = (EditText) view.findViewById(R.id.editTextPickupAddress);
        destination_address = (EditText) view.findViewById(R.id.editTextDestinationAddress);

        view.findViewById(R.id.homeFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditGroupPage.this)
                        .navigate(R.id.action_EditGroup_to_FirstFragment);
            }
        });

        view.findViewById(R.id.groupsFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditGroupPage.this)
                        .navigate(R.id.action_EditGroup_to_Groups);
            }
        });

        view.findViewById(R.id.accountFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditGroupPage.this)
                        .navigate(R.id.action_EditGroup_to_FirstFragment);
            }
        });

        binding.buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pNum = phone_number.getText().toString();
                pAdd = pickup_address.getText().toString();
                dAdd = destination_address.getText().toString();
                // saved these values but not sure how to get them to show on info page
                NavHostFragment.findNavController(EditGroupPage.this)
                        .navigate(R.id.action_EditGroup_to_GroupInfo);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
