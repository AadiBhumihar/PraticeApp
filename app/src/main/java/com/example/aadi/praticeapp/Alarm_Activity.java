package com.example.aadi.praticeapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Alarm_Activity extends AppCompatActivity implements View.OnClickListener{

    AlarmManager alarmManager;
    TimePicker time_Picker;
    TextView update_status;
    Button start_alarm ,cancel_alarm ;
    Context acontext;
    Calendar calendar;
    Intent my_intent;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        time_Picker = (TimePicker)findViewById(R.id.timePicker);
        start_alarm = (Button) findViewById(R.id.on_alarm);
        cancel_alarm =(Button) findViewById(R.id.off_alarm);
        update_status = (TextView)findViewById(R.id.u_status);
        this.acontext = this;

        calendar = Calendar.getInstance();
        my_intent = new Intent(Alarm_Activity.this,Alarm_Receiver.class);

        start_alarm.setOnClickListener(this);
        cancel_alarm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.on_alarm:
                calendar.set(Calendar.HOUR ,time_Picker.getHour());
                calendar.set(Calendar.MINUTE,time_Picker.getMinute());
                String hour_v = String.valueOf(time_Picker.getHour());
                String minute_v = String.valueOf(time_Picker.getMinute());

                pendingIntent = PendingIntent.getBroadcast(this.acontext ,0 ,my_intent ,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP ,calendar.getTimeInMillis(),pendingIntent);

                update_status.setText("Alarm Set to:"+hour_v+":"+minute_v);
                break;

            case R.id.off_alarm:
                update_status.setText("Alarm UnSet");
                break;

        }
    }
}
