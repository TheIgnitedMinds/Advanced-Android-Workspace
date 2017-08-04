package com.jain.abhishek.advanced_android_programming.graphics_multimedia.Animations_Transform;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Spinner;

import com.jain.abhishek.advanced_android_programming.R;


public class MainActivity_AnimTransform extends Activity implements  OnClickListener{

    Spinner sp1;
    ImageView iv1;

    Button btn_alpha,btn_rotate,btn_translate, btn_scale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim_transform);

        btn_alpha = (Button)findViewById(R.id.btn_alpha);
        btn_rotate = (Button)findViewById(R.id.btn_rotate);
        btn_translate = (Button)findViewById(R.id.btn_translate);
        btn_scale = (Button)findViewById(R.id.btn_scale);

        iv1 =(ImageView) findViewById(R.id.IV_bat);


        btn_alpha.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
        btn_scale.setOnClickListener(this);

        //================================================================
        //	Let's Animate Image based on the selection from Spinner
        // Don't forget to add all animation files into res/anim folder before you use following code.
        //===============================================================

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
           case R.id.btn_alpha:
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                iv1.startAnimation(alpha);
                break;

            case R.id.btn_rotate:
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv1.startAnimation(anim);
                break;

            case R.id.btn_scale:
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                iv1.startAnimation(scale);
                break;

            case R.id.btn_translate:
                Animation trans = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                iv1.startAnimation(trans);
                break;
        }
    }
}