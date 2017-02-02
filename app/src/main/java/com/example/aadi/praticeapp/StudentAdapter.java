package com.example.aadi.praticeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aadi on 10/3/16.
 */
public class StudentAdapter extends BaseAdapter {

    public Context mcontext;
   // ImageView StudentImage;
    TextView StudentName;
    TextView  StudentId;
    ArrayList<StudentDataModel>StudentActivityData;

//    StudentImage = (ImageView)
//


    public StudentAdapter(Context mcontext) {
        this.mcontext = mcontext;
        StudentActivityData = new ArrayList<>();
    }



    @Override
    public int getCount() {
        return StudentActivityData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viw = view;
        if (view==null)
        {
            viw = LayoutInflater.from(mcontext).inflate(R.layout.student_data,null,false);
        }

        //StudentImage = (ImageView)viw.findViewById(R.id.stud_img);
        StudentName = (TextView)viw.findViewById(R.id.stud_name);
        StudentId = (TextView)viw.findViewById(R.id.stud_id);

        StudentDataModel studentdatamodel = StudentActivityData.get(i);


        //StudentImage.setImageBitmap(studentdatamodel.Student_Image);
        StudentName.setText(studentdatamodel.STudent_Name);
        StudentId.setText(studentdatamodel.Student_Id);

        //viw.setScaleX(2);
        //viw.setScaleY(8);


        return viw;

    }

    public void setdata(ArrayList<StudentDataModel> data) {
        StudentActivityData = data;
        notifyDataSetChanged();
    }
}
