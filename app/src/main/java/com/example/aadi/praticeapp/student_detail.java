package com.example.aadi.praticeapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class student_detail extends AppCompatActivity  {

    GridView  StudentGrid;
    ImageView StudentImage;
    TextView  StudentName;
    TextView  StudentId;
    ArrayList<StudentDataModel>StudentData;
    Bitmap bmp1, bmp2, bmp3 ,bmp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        intilize();

        setGrid();
    }


    private void intilize() {

        StudentGrid = (GridView)findViewById(R.id.gridView);
        bmp1 = BitmapFactory.decodeResource(getResources(),R.drawable.sam4);
        bmp2 = BitmapFactory.decodeResource(getResources(),R.drawable.sam1);
        bmp3 = BitmapFactory.decodeResource(getResources() ,R.drawable.sam3);
        bmp4 = BitmapFactory.decodeResource(getResources(),R.drawable.sam2);

        StudentData = new ArrayList<>();
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));

        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));
        StudentData.add(new StudentDataModel(bmp1,"Aditya Raj","201451032"));
        StudentData.add(new StudentDataModel(bmp2,"Aditya Raj","201451033"));
        StudentData.add(new StudentDataModel(bmp3,"Aditya Raj","201451034"));
        StudentData.add(new StudentDataModel(bmp4,"Aditya Raj","201451035"));


    }

    private void setGrid() {

        StudentAdapter studentadapter = new StudentAdapter(this);
        studentadapter.setdata(StudentData);

        StudentGrid.setAdapter(studentadapter);
    }


}
