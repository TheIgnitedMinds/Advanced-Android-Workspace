package com.jain.abhishek.advanced_android_programming.graphics_multimedia.Animations_Frame;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jain.abhishek.advanced_android_programming.R;

public class MainActivity_AnimFrame extends Activity implements View.OnClickListener{

    Button BTN_anim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim_frame);

        setupButton();
        setListener();
    }

    private void setupButton()
    {
        BTN_anim = (Button)findViewById(R.id.startFAButtonId);
    }

    private void setListener()
    {
        BTN_anim.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.startFAButtonId)
        {
            animate();
        }
    }

    private void animate() {
        ImageView imgView = (ImageView) findViewById(R.id.animationImage);
        //imgView.setVisibility(View.VISIBLE);
        imgView.setBackgroundResource(R.drawable.frame_animation);

    //AnimationDrawable = An object used to create frame-by-frame animations, defined by a series of Drawable objects,
    //                    which can be used as a View object's background.

        AnimationDrawable frameAnimation = (AnimationDrawable) imgView.getBackground();

        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.start();
        }

    }
}

