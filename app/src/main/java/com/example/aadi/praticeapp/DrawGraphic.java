package com.example.aadi.praticeapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by bhumihar on 4/12/16.
 */
public class DrawGraphic extends View{

    Bitmap gballbitmap ;
    float yheight ;
    Typeface font ;

    public DrawGraphic(Context context) {
        super(context);

        gballbitmap = BitmapFactory.decodeResource(getResources() ,R.drawable.greenball1);
        yheight = 0;
        font =  Typeface.createFromAsset(context.getAssets() ,"androidnation_i.ttf");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Paint textpaint = new Paint();
        textpaint.setARGB(230,250,90,240);
        textpaint.setTextAlign(Paint.Align.CENTER);
        textpaint.setTextSize(50);
        canvas.drawText("S.......7",(canvas.getWidth()/2) ,200 ,textpaint);

        canvas.drawBitmap(gballbitmap ,(canvas.getWidth()/2-90),yheight,null);
        if (yheight<canvas.getHeight())
        {
            yheight = yheight+10;
        }
        else
        {
            yheight = 0;
        }

        Rect rect = new Rect();
        rect.set(0,700,canvas.getWidth(),800);

        Paint rpaint = new Paint();
        rpaint.setColor(Color.GREEN);
        canvas.drawRect(rect ,rpaint);


        invalidate();

    }
}
