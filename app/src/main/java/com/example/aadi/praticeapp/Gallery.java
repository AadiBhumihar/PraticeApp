package com.example.aadi.praticeapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Gallery extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView ImageGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Toolbar toolbar = (Toolbar)findViewById(R.id.g_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Animal Gallery");
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setLogo(R.drawable.wall);
           // actionBar.setDisplayHomeAsUpEnabled(true);

        }
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Groups History");
//        actionBar.setTitle("Animal Gallery");

        ImageGrid = (GridView)findViewById(R.id.gallerygridView);
        ImageGrid.setAdapter(new ImageAdapter(this));
        ImageGrid.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(Gallery.this, "" + i,
                Toast.LENGTH_SHORT).show();

    }
}
