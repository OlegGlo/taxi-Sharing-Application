package com.example.fareshare.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.databinding.ActivitySessionBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.google.android.material.navigation.NavigationView;

public class SessionActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
    private CustomerInfoViewModel CIViewModel;
    private DispatcherViewModel dispatcherViewModel;
    private DrawerLayout drawer;
    private ActivitySessionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CIViewModel = new ViewModelProvider(this).get(CustomerInfoViewModel.class);
        dispatcherViewModel = new ViewModelProvider(this).get(DispatcherViewModel.class);

        Intent intent = getIntent();
        String extra = intent.getStringExtra("customer");
        //Log.d("customer-email", "hello");

        binding = ActivitySessionBinding.inflate(getLayoutInflater());
        drawer = binding.drawerLayout;
        setContentView(binding.getRoot());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.groupsPage, R.id.profileFragment) //TODO: Update with correct pages
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.homeBottomnav,navController);
        NavigationUI.setupWithNavController(binding.navView,navController);

        dispatcherViewModel.getOffers().observe(this, offerList -> {
            if (offerList == null) {
                return;
            }
            Log.d("offers",": " + offerList.size());

            for(Offer list: offerList){
                Log.d("Offer from", list.getOfferer() + " going to" + list.getDestination().toString()
                        + ". Open to " + list.getMaxPassengers() + " passengers.");
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

}