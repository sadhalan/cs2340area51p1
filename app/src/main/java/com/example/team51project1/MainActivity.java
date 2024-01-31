package com.example.team51project1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.team51project1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //currently, dashboard is classes, and notifications is assignments
    private ActivityMainBinding binding;
    //private EditText courseCode;
    //private EditText className;

    //private Button addClassButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
/*
        courseCode = (EditText) findViewById(R.id.courseCodeInput);
        className = (EditText) findViewById(R.id.classNameInput);
*/

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_classes, R.id.navigation_assignments,
                R.id.navigation_exams)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    //public void onViewCreated()

}