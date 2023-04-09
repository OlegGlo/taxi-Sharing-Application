package com.example.fareshare.ui.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fareshare.CustomerInfoViewModel;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    CustomerInfoViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(CustomerInfoViewModel.class);

        viewModel.getAllCustomers().observe(this, customerList -> {
            if (customerList == null) {
                return;
            }
            Log.d("customers",": " + customerList.size());

            for(CustomerInfo list: customerList){
                Log.d("persons", list.getFirstName() + " " + list.getLastName());
            }
        });

    }
}
