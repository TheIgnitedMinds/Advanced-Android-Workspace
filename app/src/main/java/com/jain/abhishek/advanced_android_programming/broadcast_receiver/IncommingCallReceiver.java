package com.jain.abhishek.advanced_android_programming.broadcast_receiver;

/**
 * Created by abhishekkumarsarkar on 18/07/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class IncommingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        // Extract data included in the Intent
        CharSequence intentData = intent.getCharSequenceExtra("message");
        Toast.makeText(context, "Intent's message: "+intentData, Toast.LENGTH_LONG).show();
    }

}