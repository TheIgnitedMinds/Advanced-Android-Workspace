package com.jain.abhishek.advanced_android_programming.graphics_multimedia.Tennis_Demo;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;

import com.jain.abhishek.advanced_android_programming.R;

public class MainActivity_AnimTennis extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim_tennis);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
}
