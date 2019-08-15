package com.vaibhav.servicesdemoapp;

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

    ImageButton play;
    ImageButton pause;
    TextView status;
    BoundService myBoundService;
    boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playButton);
        pause=findViewById(R.id.pauseButton);
        status = findViewById(R.id.resultText);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnected){
                    myBoundService.Pause();
                    status.setText(myBoundService.getStatus());
                }

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnected) {
                    myBoundService.Play();
                    status.setText(myBoundService.getStatus());
                }
            }
        });

        Intent bindServiceIntent = new Intent(this, BoundService.class);
        bindService(bindServiceIntent,garageAccess,Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("BROADCAST");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);
    }

    ServiceConnection garageAccess = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.BoundServiceBinder ibinderToNextActivity = (BoundService.BoundServiceBinder) service;
            myBoundService = ibinderToNextActivity.getService();
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnected = false;
        }
    };

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            status.setText(intent.getStringExtra("Status"));
        }
    };
}
