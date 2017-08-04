package com.jain.abhishek.advanced_android_programming.app_development_topics.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by abhishekkumarsarkar on 29/05/17.
 */

public class MyServices extends Service {
    @Nullable

     // As we can see, we have to implement only one method called onBind.
    // In our case, we are using local service, so this method should return null.

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // In service lifecycle onCreate method invoke only once

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Services created :: onCreate()",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Services started :: onStartCommand()",Toast.LENGTH_LONG).show();

        String message = intent.getStringExtra("message");
        Toast.makeText(this,"Message :: "+message,Toast.LENGTH_LONG).show();

        stopSelf(); //onDestroy() will be called when we execute stopSelf()
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"Services destroyed :: onDestroy()",Toast.LENGTH_LONG).show();
    }

}
