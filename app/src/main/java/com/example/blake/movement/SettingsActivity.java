package com.example.blake.movement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.HashMap;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "SettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        final Spinner mapBackgroundSpinner = findViewById(R.id.mapBackgroundSpinner);
        ArrayAdapter<CharSequence> backgroundAdapter = ArrayAdapter.createFromResource(SettingsActivity.this, R.array.mapBackgroundOptionsArray, android.R.layout.simple_spinner_item);
        backgroundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mapBackgroundSpinner.setAdapter(backgroundAdapter);

        final Spinner pathColorSpinner = findViewById(R.id.pathColorSpinner);
        ArrayAdapter<CharSequence> pathColorAdapter = ArrayAdapter.createFromResource(SettingsActivity.this, R.array.pathColorOptionsArray, android.R.layout.simple_spinner_item);
        pathColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pathColorSpinner.setAdapter(pathColorAdapter);
        Button toGPSButton = findViewById(R.id.toGPS);

        toGPSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(SettingsActivity.this, MapActivity.class);
                startActivity(mapIntent);
            }
        });
    }
}
