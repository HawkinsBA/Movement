package com.example.blake.movement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button collect;
    private Button review;
    private Spinner gpsSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collect = findViewById(R.id.collectButton);
        review = findViewById(R.id.reviewButton);

        //Trying to populate the GPS settings spinner (which should contain "Default" and "Manual"
        //https://developer.android.com/guide/topics/ui/controls/spinner#java
        gpsSettings = findViewById(R.id.gpsSettings);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.settings_choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gpsSettings.setAdapter(adapter);


        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
