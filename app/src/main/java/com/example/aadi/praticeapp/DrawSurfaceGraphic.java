package com.example.aadi.praticeapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by bhumihar on 4/12/16.
 */
public class DrawSurfaceGraphic extends SurfaceView implements Runnable {

    SurfaceHolder surfaceHolder ;
    Thread thread = null;
    private boolean isrunning = false;



    public DrawSurfaceGraphic(Context context) {
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
            if(SurfaceGraphic.x!=0 && SurfaceGraphic.y!=0)
            {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.greenball1);
                mycanvas.drawBitmap(bitmap ,SurfaceGraphic.x - (bitmap.getWidth()/2) ,SurfaceGraphic.y- (bitmap.getHeight() /2) ,null);
            }
            if(SurfaceGraphic.sx!=0 && SurfaceGraphic.sy!=0)
            {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.splus);
                mycanvas.drawBitmap(bitmap ,SurfaceGraphic.sx - (bitmap.getWidth()/2) ,SurfaceGraphic.sy- (bitmap.getHeight() /2) ,null);
            }
            if(SurfaceGraphic.fx!=0 && SurfaceGraphic.fy!=0)
            {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.splus);
                mycanvas.drawBitmap(bitmap ,SurfaceGraphic.fx - (bitmap.getWidth()/2) ,SurfaceGraphic.fy- (bitmap.getHeight() /2) ,null);
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources() ,R.drawable.greenball1);
                mycanvas.drawBitmap(bitmap1 ,SurfaceGraphic.fx - (bitmap1.getWidth()/2)-SurfaceGraphic.anix,
                        SurfaceGraphic.fy- (bitmap1.getHeight() /2)-SurfaceGraphic.aniy,null);
            }

            SurfaceGraphic.anix = SurfaceGraphic.anix + SurfaceGraphic.scalex ;
            SurfaceGraphic.aniy = SurfaceGraphic.aniy + SurfaceGraphic.scaley ;
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
