package com.pratheepk.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


public class MyService extends Service {
    public MyService() {
    }

    MediaPlayer mediaPlayer;
    private static final String TAG ="MyServiceTAG";
    private String audioState="";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"Oncreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"OnStartCOmmand");


        mediaPlayer = MediaPlayer.create(this, R.raw.spiderman);
        mediaPlayer.start();
        float playBackSpeed = intent.getFloatExtra("PlaybackSpeed",0.0f);


        mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(playBackSpeed));
        //Configure the publisher -> send the broadcast when the event is triggered

        // track completion
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Broadcast the message --
                // create a channel
                Intent broadcastIntent = new Intent("MY_BROADCAST_CHANNEL");

                // Broadcast a message --> completion state
                broadcastIntent.putExtra("AudioStatus","Task complete!");

                // configure the local broadcast
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcastIntent);

            }
        });


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG,"OnDestroy");
        if(mediaPlayer != null)
            mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return null;
    }
}
