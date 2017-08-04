package com.jain.abhishek.advanced_android_programming.broadcast_receiver;

/**
 * Created by abhishekkumarsarkar on 18/07/17.
 */

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.jain.abhishek.advanced_android_programming.R;

public class MainActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_broadcast);

    }


    public void broadcastCustomIntent(View view)
    {
        Intent intent = new Intent("MyCustomIntent");

        EditText et = (EditText)findViewById(R.id.extraIntent);
        // add data to the Intent
        intent.putExtra("message", (CharSequence)et.getText().toString());
        intent.setAction("A_CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}