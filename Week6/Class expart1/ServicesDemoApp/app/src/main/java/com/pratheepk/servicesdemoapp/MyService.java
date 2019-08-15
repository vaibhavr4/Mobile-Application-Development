package com.pratheepk.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {
    public MyService() {
    }

    MediaPlayer mediaPlayer;
    private static final String TAG ="MyServiceTAG";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"Oncreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"OnStartCOmmand");

       // mediaPlayer = MediaPlayer.create(this, R.raw.spiderman);
       // mediaPlayer.start();

        // Make my thread to sleep
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
