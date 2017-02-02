package com.example.aadi.praticeapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by bhumihar on 4/12/16.
 */

public class MovingBall extends Activity implements View.OnTouchListener {

    DrawMovingBall drawSurfaceGraphic;
    float x =0 ,y =0;
    float sx = 0 ,sy =0;
    float fx = 0 ,fy =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawSurfaceGraphic = new DrawMovingBall(this);
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

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                fx = 0;
                fy = 0;
                break;

            case MotionEvent.ACTION_UP:
                fx = event.getX();
                fy = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                break;

        }
        return true;
    }


    public class DrawMovingBall extends SurfaceView implements Runnable  {

        SurfaceHolder surfaceHolder ;
        Thread thread = null;
        private boolean isrunning = false;


        public DrawMovingBall(Context context) {
            super(context);

            surfaceHolder = getHolder();
        }

        @Override
        public void run() {


            while (isrunning)
            {
                if (!surfaceHolder.getSurface().isValid())
                    continue;

                Canvas mycanvas = surfaceHolder.lockCanvas();
                mycanvas.drawRGB(150,105,100);
                if(x!=0 && y!=0)
                {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.greenball1);
                    mycanvas.drawBitmap(bitmap ,x - (bitmap.getWidth()/2) ,y- (bitmap.getHeight() /2) ,null);
                 }

                if(fx!=0 && fy!=0)
                {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.greenball1);
                    mycanvas.drawBitmap(bitmap ,fx - (bitmap.getWidth()/2) ,fy- (bitmap.getHeight() /2) ,null);
                }
                surfaceHolder.unlockCanvasAndPost(mycanvas);

            }
        }

        public void pause()
        {
            isrunning = false;
            while (true)
            {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            thread = null ;

        }

        public void resume()
        {
            isrunning = true;
            thread = new Thread(this);
            thread.start();
        }


    }

}
