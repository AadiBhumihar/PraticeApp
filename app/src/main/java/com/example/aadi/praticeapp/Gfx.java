package com.example.aadi.praticeapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by bhumihar on 4/12/16.
 */

public class Gfx extends Activity {


    DrawGraphic drawGraphic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawGraphic = new DrawGraphic(this);
        setContentView(drawGraphic);
    }
}
