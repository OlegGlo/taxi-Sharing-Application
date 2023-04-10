package com.example.fareshare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.databinding.ActivityRequestBinding;
import com.example.fareshare.viewmodels.RequestViewModel;

public class RequestActivity extends AppCompatActivity {

    private ActivityRequestBinding binding;
    private NavController navController;
    private RequestViewModel requestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_request);
    }


}