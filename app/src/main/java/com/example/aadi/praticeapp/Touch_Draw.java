package com.example.aadi.praticeapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by aadi on 10/4/16.
 */
public class Touch_Draw extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    int Pointer_Count;


    public Touch_Draw(Context context ,AttributeSet attrs) {
        super(context ,attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        //switch (Pointer_Count = event.getPointerCount())

        float x= event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                path.moveTo(x,y);
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;

            case MotionEvent.ACTION_UP:

                break;

            default:
                return false ;

        }

        invalidate();
        return true;
    }

 }
