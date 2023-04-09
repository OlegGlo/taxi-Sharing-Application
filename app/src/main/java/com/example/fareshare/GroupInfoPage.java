package com.example.fareshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.databinding.GroupInfoPageBinding;

public class GroupInfoPage extends Fragment {

    private GroupInfoPageBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = GroupInfoPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.homeFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GroupInfoPage.this)
                        .navigate(R.id.action_EditGroup_to_FirstFragment);
            }
        });

        view.findViewById(R.id.groupsFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GroupInfoPage.this)
                        .navigate(R.id.action_EditGroup_to_Groups);
            }
        });

        view.findViewById(R.id.accountFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GroupInfoPage.this)
                        .navigate(R.id.action_EditGroup_to_FirstFragment);
            }
        });

        binding.buttonEditGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // saved these values but not sure how to get them to show on info page
                NavHostFragment.findNavController(GroupInfoPage.this)
                        .navigate(R.id.action_GroupInfo_to_EditGroup);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
