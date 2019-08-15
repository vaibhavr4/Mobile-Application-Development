package com.pratheepk.servicesdemoapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyForegroundService extends Service {
    public MyForegroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Intent to spec ify 6yhe action
        Intent notificationIntent = new Intent(this, MainActivity.class);

        // USe pending intent to trigger my mainactivity upon user click
        PendingIntent pendingIntent = PendingIntent
                .getActivity(this,0,notificationIntent,0);

        // create a notification bar
        Notification notificationBar = new Notification.Builder(this)
                .setContentTitle("Foreground service notification")
                .setContentText("Serice is running now!")
                .setSmallIcon(R.drawable.notificationimg)
                .setContentIntent(pendingIntent)
                .build();

        // send the data about notification to the foreground
        startForeground(1,notificationBar);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
