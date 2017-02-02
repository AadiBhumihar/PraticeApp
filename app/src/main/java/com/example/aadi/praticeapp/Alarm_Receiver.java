package com.example.aadi.praticeapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by bhumihar on 28/10/16.
 */
public class Alarm_Receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("Alarm","You Have been received");
    }
}
