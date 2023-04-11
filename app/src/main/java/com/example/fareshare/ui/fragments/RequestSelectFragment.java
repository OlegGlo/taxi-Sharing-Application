package com.example.fareshare.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fareshare.R;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;
import com.example.fareshare.databinding.FragmentRequestSelectBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;
import com.example.fareshare.viewmodels.DispatcherViewModel;
import com.example.fareshare.viewmodels.RequestViewModel;

import java.util.List;


public class RequestSelectFragment extends Fragment {

    private FragmentRequestSelectBinding binding;
    private RequestViewModel requestViewModel;
    private DispatcherViewModel dispatcherViewModel;
    private CustomerInfoViewModel customerInfoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRequestSelectBinding.inflate(inflater,container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Offer> offers = requestViewModel.getOffers();
        ListView listView = binding.dynamicListview;

        String[] offers_str = new String[offers.size()];
        int index = 0;
        for (Offer offer : offers) {
            String str = "Choice " + (index + 1) + ": Offerer - " + offer.getOfferer()
                    + " | Destination - " + offer.getDestination() + " | Maximum Passengers - " + offer.getMaxPassengers();
            offers_str[index] = str;
            index++;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.fragment_request_select, offers_str);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // String item = (String) adapterView.getItemAtPosition(i);

                Offer offer_choice = offers.get(i);
                Request request = requestViewModel.getRequest();
                boolean isAccepted = dispatcherViewModel.offerAccepted(offer_choice, request);

                if (isAccepted) {
                    dispatcherViewModel.delete(request);
                    NavHostFragment.findNavController(RequestSelectFragment.this)
                            .navigate(R.id.action_requestSelectFragment_to_requestAcceptedFragment);
                } else {
                    NavHostFragment.findNavController(RequestSelectFragment.this)
                            .navigate(R.id.action_requestSelectFragment_to_requestRejectedFragment);
                }
            }
        });
    }
}