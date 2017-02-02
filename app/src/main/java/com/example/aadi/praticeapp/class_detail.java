package com.example.aadi.praticeapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class class_detail extends  Activity {

    // Holds the last position of the touch event (including movement)
    float myLastX;
    float myLastY;

    // Tracks the state of the Touch handling
    final static private int TOUCH_STATE_REST = 0;
    final static private int TOUCH_STATE_SCROLLING = 1;
    int myState = TOUCH_STATE_REST;
    private GridView routineGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        setUp();

        routineGrid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

        });
   }


 /*  @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if ((ev.getAction() == MotionEvent.ACTION_MOVE)
                &&  (myState != TOUCH_STATE_REST))
            return false;

// Grab the X and Y positions of the MotionEvent
        final float _x = ev.getX();
        final float _y = ev.getY();
        switch (ev.getAction())
        {   case MotionEvent.ACTION_MOVE:
            final int _diffX = (int) Math.abs(_x - myLastX);
            final int _diffY = (int) Math.abs(_y - myLastY);

            final boolean xMoved = _diffX > 0;
            final boolean yMoved = _diffY > 0;
            if (xMoved || yMoved)
                myState = TOUCH_STATE_SCROLLING;
            break;
            case MotionEvent.ACTION_DOWN:
                // Remember location of down touch
                myLastX = _x;
                myLastY = _y;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (myState == TOUCH_STATE_SCROLLING)
                    // Release the drag
                    myState = TOUCH_STATE_REST;

        }
        //If we are not At Rest, start handling in our own onTouch()
        return myState != TOUCH_STATE_REST;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent ev)
    {
        final int action = ev.getAction();
        final float x = ev.getX();
        final float y = ev.getY();
        final View child;

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                //Supplemental code, if needed
                break;
            case MotionEvent.ACTION_MOVE:
                // This handles Scrolling only.
                if (myState == TOUCH_STATE_SCROLLING)
                {
                    // Scroll to follow the motion event
                    // This will update the vars as long as your finger is down.
                    final int deltaX = (int) (myLastX - x);
                    final int deltaY = (int) (myLastY - y);
                    myLastX = (int) x;
                    myLastY = (int) y;
                    scrollBy(deltaX, deltaY);
                }
                break;
            case MotionEvent.ACTION_UP:
                // If Scrolling, stop the scroll so we can scroll later.
                if (myState == TOUCH_STATE_SCROLLING)
                    myState = TOUCH_STATE_REST;
                break;
            case MotionEvent.ACTION_CANCEL:
                // This is just a failsafe. I don't even know how to cancel a touch event
                myState = TOUCH_STATE_REST;
        }

        return true;
    }

    private void scrollBy(int deltaX, int deltaY) {

        routineGrid.scrollBy(deltaX,deltaY);

    }
*/

    public void setUp(){


        ArrayList<RoutineDataModel> dataModels = new ArrayList<>();

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));

        dataModels.add(new RoutineDataModel("EL101\n\nIT407\n\nCS403","Digital Logic Design\n\nDLD\n\nPR","TE!","KKJ","9101"));






        routineGrid = (GridView) findViewById(R.id.routineGrid);
        routineGrid.setStretchMode(GridView.NO_STRETCH);
        routineGrid.setNumColumns(2);
        routineGrid.setColumnWidth(800);



        RoutineAdapter routineAdapter = new RoutineAdapter(this);
        routineAdapter.setmRoutineDataList(dataModels);
        routineGrid.setAdapter(routineAdapter);



    }


}
