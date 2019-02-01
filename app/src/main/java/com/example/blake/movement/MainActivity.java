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
    private Button collect;
    private Button review;
    private Button toGPS;
    private Spinner gpsSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collect = findViewById(R.id.collectButton);
        review = findViewById(R.id.reviewButton);
        // Idea: Need to inflate settings_dialogue.xml and set toGPS through mView or else toGPS is a null-pointer
        // 2/1/2019 10:33 AM: Something's not working - cannot access onClickListener for toGPS.
        // 2/1/2019 10:52 AM: After testing with log messages, it doesn't look like toGPS is null after toGPS = mView.findViewById(R.id.settingsConfirm);
        View mView = getLayoutInflater().inflate(R.layout.settings_dialogue, null);
        toGPS = mView.findViewById(R.id.settingsConfirm);
        if (toGPS.equals(null)){
            Log.d(TAG, "Bad");
        } else {
            Log.d(TAG, "Good");
        }


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
                View mView = getLayoutInflater().inflate(R.layout.settings_dialogue, null);

                // Trying to populate the GPS settings spinner (which should contain "Default" and "Manual"
                // https://developer.android.com/guide/topics/ui/controls/spinner#java
                gpsSettings = mView.findViewById(R.id.gpsSettings);
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
                Toast.makeText(MainActivity.this, "toGPS pressed", Toast.LENGTH_SHORT).show();
                Intent gpsIntent = new Intent(MainActivity.this, GPSActivity.class);
                startActivity(gpsIntent);
            }
        });
    }
}
