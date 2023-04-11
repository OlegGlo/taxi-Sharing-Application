package com.example.fareshare.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fareshare.Globals;
import com.example.fareshare.R;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.databinding.FragmentProfileBinding;
import com.example.fareshare.viewmodels.CustomerInfoViewModel;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private CustomerInfoViewModel CIViewModel;

    TextView AccountName;
    TextView AccountPhone;
    TextView AccountEmail;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String idGlobal = ((Globals) getActivity().getApplication()).getCustomerID();

        CIViewModel = new ViewModelProvider(requireActivity()).get(CustomerInfoViewModel.class);

        CustomerInfo id = CIViewModel.getByEmail(idGlobal);

        String textName = id.getFullName();
        String textPhone = id.getPhoneNumber();
        String textEmail = id.getEmail();
        ImageView imageView = binding.imageView3;

        AccountName = (TextView) view.findViewById(R.id.AccountNameField);
        AccountPhone = (TextView) view.findViewById(R.id.AccountPhoneNumField);
        AccountEmail = (TextView) view.findViewById(R.id.AccountEmailField);

        AccountName.setText(textName);
        AccountPhone.setText(textPhone);
        AccountEmail.setText(textEmail);

        imageView.setImageResource(R.drawable.profile_icon);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}