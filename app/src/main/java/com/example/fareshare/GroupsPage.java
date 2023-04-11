package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.GroupsPageBinding;

public class GroupsPage extends Fragment {

    private GroupsPageBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = GroupsPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.homeFragment).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(GroupsPage.this)
//                        .navigate(R.id.action_groupsPage_to_homeFragment);
//            }
//        });
//
//        view.findViewById(R.id.groupsPage).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(GroupsPage.this)
//                        .navigate(R.id.action_groupsPage_to_groupsPage);
//            }
//        });
//
//        view.findViewById(R.id.accountFragment).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(GroupsPage.this)
//                        .navigate(R.id.action_groupsPage_to_accountFragment);
//            }
//        });

        binding.buttonCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GroupsPage.this)
                        .navigate(R.id.action_groupsPage_to_createGroupPage);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
