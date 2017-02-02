package com.example.aadi.praticeapp;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class camera extends AppCompatActivity implements View.OnClickListener  {

    ImageView imageView;
    ImageButton imageButton;
    Button Camerabtn;
    Intent Camera_Intent;
    final static int CameraData = 0;
    private static final int REQUEST_CAMERA_RESULT = 201;
    private static final int REQUEST_WALLPAPER_RESULT = 202;
    Bitmap bmp;
    private AppCompatDelegate delegate;

    TextView read,write;
    String state;
    private String folder = "/storage/emulated/0/aditya";
    File dir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //delegate = AppCompatDelegate.create(this, this);
        super.onCreate(savedInstanceState);
        //delegate.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppToolC);
        setSupportActionBar(toolbar);

        intilize();
        ExternalRead();

        imageButton.setOnClickListener(this);
        Camerabtn.setOnClickListener(this);


    }

    private void ExternalRead() {

        state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            write.setText("WriteTrue");
            read.setText("ReadTrue");

        }else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            write.setText("WriteFalse");
            read.setText("ReadTrue");

        }else {
            write.setText("WriteFalse");
            read.setText("ReadFalse");

        }

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

        switch (item.getItemId())
        {
            case R.id.new_folder:

                dir = new File(folder);
                try{
                    if(dir.mkdir()) {
                        Toast.makeText(this ,"Directory is created" ,Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this ,"Directory is not created" ,Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;

            case R.id.delete_folder:
                if (deleteFolder(dir))
                {
                    Toast.makeText(this ,"Directory deleted" ,Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(this ,"Directory not deleted" ,Toast.LENGTH_SHORT).show();
                }
        }

        return false;
    }

    private boolean deleteFolder(File dir) {

        if (dir.isDirectory())
        {
            String[] child = dir.list();
            for (int i=0;i<child.length;i++)
            {
                boolean delete = deleteFolder(new File(dir ,child[i]));
                if (!delete)
                    return false;
            }
        }
        return dir.delete();

    }

    private void intilize() {
        imageView = (ImageView) findViewById(R.id.imageView);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        Camerabtn = (Button) findViewById(R.id.camera);
        read = (TextView)findViewById(R.id.readtext);
        write = (TextView)findViewById(R.id.writetext);

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.camera:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (this.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        TakePhoto();
                    } else {
                        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                            Toast.makeText(this, "Permission is needed to access the Camera", Toast.LENGTH_SHORT).show();
                        }
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, REQUEST_CAMERA_RESULT);
                    }
                } else {
                    TakePhoto();
                }

                break;

            case R.id.imageButton:

                SetWallpaper();


                break;

        }

    }

    private void SetWallpaper() {


        AlertDialog.Builder dialog = new AlertDialog.Builder(camera.this);
        dialog.setTitle("Walllpaper");
        dialog.setMessage("Set Wallpaper");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        dialog.setNegativeButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();


    }


    private void TakePhoto() {

        Camera_Intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(Camera_Intent, CameraData);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extra = data.getExtras();
            bmp = (Bitmap) extra.get("data");
            imageView.setImageBitmap(bmp);

        }

    }


}