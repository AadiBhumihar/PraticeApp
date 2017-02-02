package com.example.aadi.praticeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_time_table);

        //Toolbar toolbar = (Toolbar)findViewById(R.id.AppToolT);
        //setSupportActionBar(toolbar);

        init();

    }

    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.tablelayout);

        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" Sl.No ");
        tv0.setTextColor(Color.BLACK);
        //tv0.setGravity(Gravity.CENTER);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Product ");
        tv1.setTextColor(Color.BLACK);
       // tv1.setGravity(Gravity.CENTER);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Unit Price ");
        tv2.setTextColor(Color.BLACK);
       // tv2.setGravity(Gravity.CENTER);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Stock Remaining ");
        tv3.setTextColor(Color.BLACK);
       // tv3.setGravity(Gravity.CENTER);
        tbrow0.addView(tv3);
        TextView tv8 = new TextView(this);
        tv8.setText(" 10 Product ");
        tv8.setTextColor(Color.BLACK);
        //tv8.setGravity(Gravity.CENTER);
        tbrow0.addView(tv8);


        TextView tv4 = new TextView(this);
        tv4.setText(" Sl.No ");
        tv4.setTextColor(Color.BLACK);
       // tv4.setGravity(Gravity.CENTER);
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setText(" Product ");
        tv5.setTextColor(Color.BLACK);
       // tv5.setGravity(Gravity.CENTER);
        tbrow0.addView(tv5);
        TextView tv6 = new TextView(this);
        tv6.setText(" Unit Price ");
        tv6.setTextColor(Color.BLACK);
       // tv6.setGravity(Gravity.CENTER);
        tbrow0.addView(tv6);
        TextView tv7 = new TextView(this);
        tv7.setText(" Stock Remaining ");
        tv7.setTextColor(Color.BLACK);
        //tv7.setGravity(Gravity.CENTER);
        tbrow0.addView(tv7);
        TextView tv9 = new TextView(this);
        tv9.setText(" 20 Product ");
        tv9.setTextColor(Color.BLACK);
       // tv9.setGravity(Gravity.CENTER);
        tbrow0.addView(tv9);

        stk.addView(tbrow0);
        //stk.addView(tbrow3);

         }
}
