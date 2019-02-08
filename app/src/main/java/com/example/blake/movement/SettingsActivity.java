package com.example.blake.movement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "SettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        final Spinner mapBackgroundSpinner = findViewById(R.id.mapBackgroundSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SettingsActivity.this, R.array.mapBackgroundOptionsArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mapBackgroundSpinner.setAdapter(adapter);
    }
}
