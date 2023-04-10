package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.CreateGroupPageBinding;

public class CreateGroupPage extends Fragment {

    private CreateGroupPageBinding binding;
    EditText emails;
    EditText pickup_address;
    EditText destination_address;
    String emails_string;
    String pickup_string;
    String destination_string;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CreateGroupPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emails = (EditText) view.findViewById(R.id.group_emails);
        pickup_address = (EditText) view.findViewById(R.id.group_leader_pickup_address);
        destination_address = (EditText) view.findViewById(R.id.group_leader_destination_address);

        binding.buttonCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emails_string = emails.getText().toString();
                pickup_string = pickup_address.getText().toString();
                destination_string = destination_address.getText().toString();
                // saved these values but not sure how to get them to show on info page
                NavHostFragment.findNavController(CreateGroupPage.this)
                        .navigate(R.id.action_createGroupPage_to_groupInfoPage);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
