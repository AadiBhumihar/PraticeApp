package com.example.aadi.praticeapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;




/**
 * Created by bhumihar on 4/12/16.
 */

public class SurfaceGraphic extends Activity implements View.OnTouchListener{

    DrawSurfaceGraphic drawSurfaceGraphic;
    static float x =0 ,y =0;
    static float sx ,sy;
    static float fx  ,fy ;
    static float dx ,dy , anix ,aniy ,scalex ,scaley ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         x = y = sx = sy = fx = fy = 0 ;

        drawSurfaceGraphic = new DrawSurfaceGraphic(this);
        drawSurfaceGraphic.setOnTouchListener(this);
        setContentView(drawSurfaceGraphic);

    }


    @Override
    protected void onResume() {
        super.onResume();
        drawSurfaceGraphic.resume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        drawSurfaceGraphic.pause();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                sx = event.getX();
                sy = event.getY();
                dx = dy = anix = aniy = scalex = scaley = 0;
                fx = fy = 0 ;
                break;

            case MotionEvent.ACTION_UP:
                fx = event.getX();
                fy = event.getY();
                dx = fx-sx;
                dy = fy - sy;
                scalex = dx/30;
                scaley = dy /30;
                x = y = 0;
                break;


        }
        return true;
    }
}
