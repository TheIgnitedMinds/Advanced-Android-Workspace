package com.jain.abhishek.advanced_android_programming.app_development_topics.Services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jain.abhishek.advanced_android_programming.R;

/**
 * Created by abhishekkumarsarkar on 29/05/17.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnstart, btnstop;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_services);

        //getting the ids of the views from XML code
        getUI();

        //setting clicklistener on the view elements
        setListener();

    }

    private void  getUI()
    {
        btnstart = (Button)findViewById(R.id.BTN_start);
        btnstop = (Button)findViewById(R.id.BTN_stop);
    }


    private void setListener()
    {
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.BTN_start)
        {
            startServiceMethod();  // start the service

        }else {
            stopServiceMethod();  // forcefully stopping the service
        }

    }


    public  void  startServiceMethod()
    {
        Intent i = new Intent(this, MyServices.class);
        i.putExtra("message","StartServiceMethod called..");
        startService(i);

    }


    public void stopServiceMethod()
    {

        Intent j = new Intent(this, MyServices.class);
        stopService(j);
    }


}
