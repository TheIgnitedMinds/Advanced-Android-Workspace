package com.jain.abhishek.advanced_android_programming.graphics_multimedia.Animations_Canvas;

/**
 * Created by abhishekkumarsarkar on 15/05/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jain.abhishek.advanced_android_programming.R;

public class MainActivity_AnimCanvas extends Activity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim_canvas);

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }

}