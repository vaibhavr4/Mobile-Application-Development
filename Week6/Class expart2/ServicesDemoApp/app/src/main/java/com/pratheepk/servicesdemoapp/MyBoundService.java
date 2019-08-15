package com.pratheepk.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;


//garage
public class MyBoundService extends Service {
    public MyBoundService() {
    }

    MediaPlayer mediaPlayer;


    public String getAudioStatus() {
        return audioStatus;
    }

    public void setAudioStatus(String audioStatus) {
        this.audioStatus = audioStatus;
    }

    private String audioStatus;
    //Ladder -> iBinder interface
    private IBinder ibinder = new MyBoundServiceKey();

    //Key to access the garage
    public class MyBoundServiceKey extends Binder {

        MyBoundService getService(){
            // return the instance of this service
            return  MyBoundService.this;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.spiderman);

    }

    //Car --> method you should be able to access outside the service
    public void PlayMusic(){
        // set the string as "Playing"
        setAudioStatus("Playing");
        mediaPlayer.start();
    }

    public void PauseMusic(){

        setAudioStatus("Paused");
        mediaPlayer.pause();
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return ibinder;
    }
}
