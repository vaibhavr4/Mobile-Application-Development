package com.pratheepk.servicesdemoapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //Three image buttons
    private ImageButton playButton;
    private ImageButton pauseButton;
    private ImageButton stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        pauseButton=findViewById(R.id.pauseButton);
        stopButton= findViewById(R.id.stopButton);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start my service here --> MyService
                //Intent intent = new Intent(MainActivity.this, MyService.class);
                //startService(intent);

                // Start my service here --> MyIntentService
                //Intent intent = new Intent(MainActivity.this, MyIntentService.class);
               // startService(intent);

                //Start Foregrpund servcoie
                Intent intent = new Intent(MainActivity.this, MyForegroundService.class);
                startService(intent);
            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyForegroundService.class);
                stopService(intent);

            }
        });

    }
}
