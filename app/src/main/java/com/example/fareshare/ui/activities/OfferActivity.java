package com.example.fareshare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.databinding.ActivityOfferBinding;
import com.example.fareshare.viewmodels.OfferViewModel;

public class OfferActivity extends AppCompatActivity {

    private ActivityOfferBinding binding;
    private NavController navController;
    private OfferViewModel offerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOfferBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_offer);
    }


}