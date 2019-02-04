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

        Button collect = findViewById(R.id.collectButton);
        Button review = findViewById(R.id.reviewButton);
        final View mView = getLayoutInflater().inflate(R.layout.settings_dialogue, null);
        Button toGPS =  mView.findViewById(R.id.settingsConfirm);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Review pressed", Toast.LENGTH_SHORT).show();
            }
        });

        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                Spinner gpsSettings = mView.findViewById(R.id.gpsSettings);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.settings_choices, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                gpsSettings.setAdapter(adapter);
                mBuilder.setView(mView);
                AlertDialog settingsDialog = mBuilder.create();
                settingsDialog.show();
            }
        });

        toGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpsIntent = new Intent(MainActivity.this, GPSActivity.class);
                startActivity(gpsIntent);
            }
        });
    }
}
