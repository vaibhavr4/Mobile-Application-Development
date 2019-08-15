package com.pratheepk.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
    public TestService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"I'm in onCreate") ;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.spiderman);

        mediaPlayer.start();
        Log.d(TAG,"I'm in onStartCommand") ;

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Log.d(TAG,"I'm in onDestroy") ;
    }

    MediaPlayer mediaPlayer;
    private static final String TAG ="ServiceTAG";
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
