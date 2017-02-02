package com.example.aadi.praticeapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by aadi on 8/24/16.
 */
public class menu extends ListActivity {

    String[] Menu = new String[] {"LifeCycle","class_detail","Gallery","student_detail","Touch_activity" ,"Frame_View" ,
            "Side_Navigation","Alarm_Activity","FireBase_Activity","MapsActivity","BasicMap","Gfx","SurfaceGraphic","MovingBall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> list = new ArrayAdapter<String>(menu.this ,android.R.layout.simple_list_item_1 ,Menu);
        setListAdapter(list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String clas = Menu[position];

        try {
            Class New_Class = Class.forName("com.example.aadi.praticeapp."+clas);
            Intent New_Activity = new Intent(menu.this ,New_Class);
            startActivity(New_Activity);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
