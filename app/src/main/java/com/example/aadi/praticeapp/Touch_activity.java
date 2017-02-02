package com.example.aadi.praticeapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by aadi on 10/4/16.
 */
public class Touch_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new Touch_Draw(this, null));
    }

}
