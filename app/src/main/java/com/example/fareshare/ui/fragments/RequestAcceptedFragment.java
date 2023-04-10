package com.example.fareshare.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fareshare.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestAcceptedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestAcceptedFragment extends Fragment {

    public RequestAcceptedFragment() {
        // Required empty public constructor
    }

    public static RequestAcceptedFragment newInstance() {
        RequestAcceptedFragment fragment = new RequestAcceptedFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_accepted, container, false);
    }
}