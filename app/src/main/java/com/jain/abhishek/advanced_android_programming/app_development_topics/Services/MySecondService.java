package com.jain.abhishek.advanced_android_programming.app_development_topics.Services;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by abhishekkumarsarkar on 30/05/17.
 */

public class MySecondService extends IntentService {

    public MySecondService() {
        super("My services");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Services created :: Oncreate",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Services started :: onStartCommand ",Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {

        Toast.makeText(this,"Services Destroy :: onDestroy ",Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}
