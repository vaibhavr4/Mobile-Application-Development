package com.pratheepk.servicesdemoapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("IntentServiceForPratheep");
    }

    private static final String TAG ="MyServiceTAG";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Oncreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"onHandleIntent");

        // Make my thread to sleep
     /*   try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy");
    }
}
