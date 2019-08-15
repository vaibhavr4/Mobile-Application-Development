package com.pratheepk.servicesdemoapp;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Three image buttons
    private ImageButton playButton;
    private ImageButton pauseButton;
    private ImageButton stopButton;
    private TextView resultTextView;

    // variable to hold MyBound Services
    MyBoundService myBoundService;

    // Boolean check to check for the connectivity status
     boolean isBoundConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        pauseButton=findViewById(R.id.pauseButton);
        stopButton= findViewById(R.id.stopButton);
        resultTextView = findViewById(R.id.resultText);


        /// establish the binding to service
       // Intent bindServiceIntent = new Intent(this, MyBoundService.class);

        // initiate binding process
        //bindService(bindServiceIntent,accessToGarage,Context.BIND_AUTO_CREATE);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // start music - > PlayMusic function from bound service
              /*  if(isBoundConnection) {
                    myBoundService.PlayMusic();
                    resultTextView.setText(myBoundService.getAudioStatus());
                }*/


                // Start my service here --> MyService
                Intent intent = new Intent(MainActivity.this, MyService.class);

                // send the playbackspeed to the mediaplayer (MyService)
                intent.putExtra("PlaybackSpeed",1.7f);
                startService(intent);

                // Start my service here --> MyIntentService
                //Intent intent = new Intent(MainActivity.this, MyIntentService.class);
               // startService(intent);

                //Start Foregrpund servcoie
               // Intent intent = new Intent(MainActivity.this, MyForegroundService.class);
                //startService(intent);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if(isBoundConnection){
                    myBoundService.PauseMusic();
                    resultTextView.setText(myBoundService.getAudioStatus());
                }*/

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

    // establish a service connection ----> access tO garage
    ServiceConnection accessToGarage = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //if connected

            isBoundConnection = true;
            // grab the key to garage
            MyBoundService.MyBoundServiceKey keyDeliveredToActivity = (MyBoundService.MyBoundServiceKey) service;
            myBoundService = keyDeliveredToActivity.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBoundConnection = false;
        }
    };


    // registger the receiver

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("MY_BROADCAST_CHANNEL");

        // register this intent filter
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver,intentFilter);
    }



    // create a receiver
    BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // the functionality for receiving
            String result = intent.getStringExtra("AudioStatus");

            // update the UI text with the result
            resultTextView.setText(result);
        }
    };


}
