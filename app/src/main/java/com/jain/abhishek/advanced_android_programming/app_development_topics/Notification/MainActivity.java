package com.jain.abhishek.advanced_android_programming.app_development_topics.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jain.abhishek.advanced_android_programming.R;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notification);

        //getting the ids of the views from XML code
        getUI();

        //setting clicklistener on the view elements
        setListener();

    }

    private void getUI()
    {
        btnShow = (Button) findViewById(R.id.btnShowNotification);
        btnClear = (Button) findViewById(R.id.btnClearNotification);
    }

    private void setListener()
    {
        btnShow.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnShowNotification:

                manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent intent = new Intent(MainActivity.this,NewActivity.class);

                //You use a PendingIntent to specify the action, which should be performed
                // once the user select or click the notification.

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);
                pendingIntent.cancel();

               // Provides a convenient way to set the various fields of a Notification and
                // generate content views using the platform's notification layout template.

                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setAutoCancel(false);
                builder.setContentTitle("WhatsApp Notification");
                builder.setContentText("You have a new message");
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(true);
                builder.setSubText("This is subtext... Please try this out by yourself");
                builder.setNumber(100);
                builder.build();
                builder.addAction(R.drawable.ic_launcher, "Call", pendingIntent);
                builder.addAction(R.drawable.ic_launcher, "More", pendingIntent);

                myNotication = builder.getNotification();
                manager.notify(11, myNotication);

                break;

            case R.id.btnClearNotification:
                manager.cancel(11);

                break;
        }

    }
}
