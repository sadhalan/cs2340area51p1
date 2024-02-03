package com.example.team51project1.ui.classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.team51project1.R;
import com.example.team51project1.databinding.FragmentClassesBinding;
import com.example.team51project1.ui.home.HomeFragment;

public class AddClassFragment extends Fragment {

    private FragmentClassesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClassesViewModel classesViewModel =
                new ViewModelProvider(this).get(com.example.team51project1.ui.classes.ClassesViewModel.class);


        binding = FragmentClassesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        classesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.backToClassesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddClassFragment.this)
                        .navigate(R.id.action_navigation_add_class_to_navigation_classes);
            }
        });
/*
        binding.backToClassesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AddClassFragment.this)
                        .navigate(R.id.action_navigation_add_class_to_navigation_classes);
            }
        });
*/





    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}