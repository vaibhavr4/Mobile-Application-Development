package com.vaibhav.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;


public class BoundService extends Service {

    MediaPlayer media;
    String status;
    IBinder ibinder = new BoundServiceBinder();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void clearAudioStatus(){
        this.status = "";
    }

    public class BoundServiceBinder extends Binder {
        BoundService getService(){
            return  BoundService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        media = MediaPlayer.create(this, R.raw.spiderman);

        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent broadcastIntent = new Intent("BROADCAST");
                broadcastIntent.putExtra("Status","Done");
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcastIntent);
                clearAudioStatus();
            }
        });

    }

    public void Play(){
        setStatus("Playing");
        media.start();
    }

    public void Pause(){
        if(media.isPlaying()){
            setStatus("Paused");
            media.pause();
        }
        else {
            media.pause();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return ibinder;
    }

    public BoundService() {
    }
}
