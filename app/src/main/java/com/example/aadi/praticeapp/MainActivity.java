package com.example.aadi.praticeapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String name , age , sex;
    ListView listView;
    TextView tv;
    String[] array = new String[]{"Aditya", "Raj" ,"Sector007"};
    ArrayList<String> input_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.AppTool);
        setSupportActionBar(toolbar);

        initilize();

        ArrayAdapter<String> list = new ArrayAdapter<String>(MainActivity.this ,R.layout.input ,R.id.input ,input_list);
        listView.setAdapter(list);

        listView.setOnItemClickListener(this);

    }

    private void initilize() {

        listView = (ListView)findViewById(R.id.List_View);
        tv = (TextView)findViewById(R.id.list_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.list_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_insert:

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("UserDetail");
                dialog.setMessage("Enter User Detail");
                final EditText input1 = new EditText(MainActivity.this);
                input1.setHint("Enter Name");
                final EditText input2 = new EditText(MainActivity.this);
                input2.setHint("Enter Age");
                final EditText input3 = new EditText(MainActivity.this);
                input3.setHint("Enter Sex");

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setLayoutParams(new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT));

                linearLayout.addView(input1);
                linearLayout.addView(input2);
                linearLayout.addView(input3);

                dialog.setView(linearLayout);

                dialog.setNegativeButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        name = input1.getText().toString();
                        input_list.add(name);
                        age = input2.getText().toString();
                        input_list.add(age);
                        sex = input3.getText().toString();
                        input_list.add(sex);

                        InputMethodManager close_window = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        close_window.hideSoftInputFromWindow(input3.getWindowToken(),0);

                        TextView input_text1 = (TextView)findViewById(R.id.input_view1);
                        input_text1.setText(name);

                        TextView input_text2 = (TextView)findViewById(R.id.input_view2);
                        input_text2.setText(age);

                        TextView input_text3 = (TextView)findViewById(R.id.input_view3);
                        input_text3.setText(sex);



                    }
                });
                dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();

                break;

        }

        return false;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String menu = ((TextView)view).getText().toString();

        tv.setText(menu);

        Random random = new Random();
        tv.setGravity(random.nextInt(80));
        tv.setTextColor(Color.rgb(random.nextInt(255) ,random.nextInt(256) ,random.nextInt(257)));


    }


}
