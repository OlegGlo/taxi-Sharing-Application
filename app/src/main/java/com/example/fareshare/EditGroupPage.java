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

        binding = EditGroupPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emails = (EditText) view.findViewById(R.id.edit_emails);
        pickup_address = (EditText) view.findViewById(R.id.edit_pickup_address);
        destination_address = (EditText) view.findViewById(R.id.edit_destination_address);
        emails.setText("get emails from DB");
        pickup_address.setText("get pickup from DB");
        destination_address.setText("get destination from DB");

        binding.buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emails_string = emails.getText().toString();
                pickup_string = pickup_address.getText().toString();
                destination_string = destination_address.getText().toString();
                //save to db
                NavHostFragment.findNavController(EditGroupPage.this)
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
