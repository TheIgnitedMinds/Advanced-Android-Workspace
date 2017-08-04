package com.jain.abhishek.advanced_android_programming.threads_processes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jain.abhishek.advanced_android_programming.R;

/**
 * Created by abhishekkumarsarkar on 08/07/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv_thread;
    EditText et_sleep;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_async);


        et_sleep = (EditText)findViewById(R.id.Et_thread);
        tv_thread= (TextView)findViewById(R.id.tv_thread);

        btn_start = (Button)findViewById(R.id.btn_threadStart);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn_threadStart)
        {
            // This starts the AsyncTask
            // Doesn't need to be in onCreate()


            MyTask runner = new MyTask();
        String sleepTime = et_sleep.getText().toString();
        runner.execute(sleepTime);
    }
    }


    // Here is the AsyncTask class:
    //
    // AsyncTask<Params, Progress, Result>.
    //    Params – the type (Object/primitive) you pass to the AsyncTask from .execute()
    //    Progress – the type that gets passed to onProgressUpdate()
    //    Result – the type returns from doInBackground()
    // Any of them can be String, Integer, Void, etc.




    private class MyTask extends AsyncTask<String,String,String>
   {

       private String resp;
       ProgressDialog progressDialog;

       // This is run in a background thread


       @Override
       protected String doInBackground(String... val) {

           publishProgress("Sleeping..."); // Calls onProgressUpdate()

           try {
               int time = Integer.parseInt(val[0])*1000;

               Thread.sleep(time);
               resp = " waited for " + val[0] + " seconds";

           } catch (Exception e) {
               e.printStackTrace();
               resp = e.getMessage();
           }

           return resp;
       }

       // Runs in UI before background thread is called

       @Override
       protected void onPreExecute() {

          // Toast.makeText(MainActivity.this,"thread running",Toast.LENGTH_LONG).show();
           progressDialog = ProgressDialog.show(MainActivity.this,
                   "ProgressDialog",
                   "Wait for "+et_sleep.getText().toString()+ " seconds");
       }

       // This runs in UI when background thread finishes

       @Override
       protected void onPostExecute(String val) {
           super.onPostExecute(val);

           progressDialog.dismiss();
           tv_thread.setText(val);
       }


       protected void onProgressUpdate(String... values) {
           tv_thread.setText(values[0]);
       }
   }


}
