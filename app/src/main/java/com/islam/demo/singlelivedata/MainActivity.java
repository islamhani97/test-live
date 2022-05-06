package com.islam.demo.singlelivedata;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Button singleLiveDataButton = findViewById(R.id.single_live_data);
        Button normalLiveDataButton = findViewById(R.id.normal_live_data);

        mainViewModel.getSingleLiveData().observe(this, s ->
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show());

        mainViewModel.getNormalLiveData().observe(this, s ->
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show());

        singleLiveDataButton.setOnClickListener(v ->
                mainViewModel.RequestSingleLiveData());

        normalLiveDataButton.setOnClickListener(v ->
                mainViewModel.RequestNormalLiveData());
    }
}