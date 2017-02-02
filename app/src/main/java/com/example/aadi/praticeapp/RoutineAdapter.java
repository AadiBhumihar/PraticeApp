package com.example.aadi.praticeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aadi on 10/2/16.
 */
public class RoutineAdapter extends BaseAdapter {


    private Context context;
    public ArrayList<RoutineDataModel> mRoutineDataList;

    private TextView mCourse;
    private TextView mCourseName;
    private TextView mBatch;
    private TextView mFaculty;
    private TextView mRoomNum;


    public RoutineAdapter(){

    }

    public RoutineAdapter(Context context){
        this.context = context;
        this.mRoutineDataList = new ArrayList<>();
    }

    public void setmRoutineDataList(ArrayList<RoutineDataModel> list){

        this.mRoutineDataList = list;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mRoutineDataList.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;

        if(v==null){

            v = LayoutInflater.from(context).inflate(R.layout.class_value,null,false);

        }

        // init

        mCourse = (TextView) v.findViewById(R.id.course);
        mCourseName = (TextView) v.findViewById(R.id.course_name);
        mBatch = (TextView) v.findViewById(R.id.batch);
        mFaculty = (TextView) v.findViewById(R.id.faculty);
        mRoomNum = (TextView) v.findViewById(R.id.room_no);

        // TODO: bind data

        RoutineDataModel dataModel = mRoutineDataList.get(position);

        mCourse.setText(dataModel.Course);
        mCourseName.setText(dataModel.CourseName);
        mBatch.setText(dataModel.Batch);
        mFaculty.setText(dataModel.Faculty);
        mRoomNum.setText(dataModel.RoomNumber);

        return v;

    }
}
