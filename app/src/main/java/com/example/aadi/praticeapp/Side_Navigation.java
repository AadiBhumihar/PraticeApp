package com.example.aadi.praticeapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Side_Navigation extends AppCompatActivity implements ListView.OnItemClickListener
{

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side__navigation);

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[3];

       drawerItem[0] = new ObjectDrawerItem(R.drawable.icon_for, "forest");
       drawerItem[1] = new ObjectDrawerItem(R.drawable.icon_pai, "Paint");
       drawerItem[2] = new ObjectDrawerItem(R.drawable.icon_com, "Compose");

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.nav_list_item, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectItem(i);
    }

    private void selectItem(int i) {

            CreateFragment fragment = null;

            switch (i) {
                case 0:
                    fragment = new CreateFragment();
                    break;
                case 1:
                    //fragment = new ReadFragment();
                    break;
                case 2:
                    //fragment = new HelpFragment();
                    break;

                default:
                    break;
            }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(i, true);
            mDrawerList.setSelection(i);
            getActionBar().setTitle(mNavigationDrawerItemTitles[i]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
