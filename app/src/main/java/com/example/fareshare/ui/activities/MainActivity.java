package com.example.fareshare.ui.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fareshare.data.DispatcherRepository;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.databinding.ActivityMainBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CustomerInfoViewModel customerInfoViewModel;
    private DispatcherViewModel dispatcherViewModel;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        customerInfoViewModel = new ViewModelProvider(this).get(CustomerInfoViewModel.class);
        dispatcherViewModel = new ViewModelProvider(this).get(DispatcherViewModel.class);

        customerInfoViewModel.getAllCustomers().observe(this, customerList -> {
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
