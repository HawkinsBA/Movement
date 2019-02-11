package com.example.blake.movement;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button collectButton = findViewById(R.id.collectButton);
        Button reviewButton = findViewById(R.id.reviewButton);
        final View mView = getLayoutInflater().inflate(R.layout.settings_dialogue, null);
        Button toGPSButton =  mView.findViewById(R.id.toGPSButton);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        final Spinner manualOrDefaultSpinner = mView.findViewById(R.id.manualOrDefaultSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.manualOrDefaultArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        manualOrDefaultSpinner.setAdapter(adapter);
        mBuilder.setView(mView);
        final AlertDialog manualOrDefaultDialog = mBuilder.create();

        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reviewIntent = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(reviewIntent);
            }
        });

        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manualOrDefaultDialog.show();
            }
        });

        toGPSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (manualOrDefaultSpinner.getSelectedItem().toString().equals("Default")) {
                    Intent mapIntent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(mapIntent);
                } else {
                    Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(settingsIntent);
                }
            }
        });
    }
}
