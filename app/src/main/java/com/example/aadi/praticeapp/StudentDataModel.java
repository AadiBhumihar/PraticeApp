package com.example.aadi.praticeapp;

import android.graphics.Bitmap;

/**
 * Created by aadi on 10/3/16.
 */
public class StudentDataModel  {

    Bitmap Student_Image;
    String STudent_Name;
    String Student_Id;

    public StudentDataModel(Bitmap student_Image, String STudent_Name, String student_Id) {
        Student_Image = student_Image;
        this.STudent_Name = STudent_Name;
        Student_Id = student_Id;
    }

    public void setSTudent_Name(String STudent_Name) {
        this.STudent_Name = STudent_Name;
    }

    public void setStudent_Id(String student_Id) {
        Student_Id = student_Id;
    }

    public void setStudent_Image(Bitmap student_Image) {

        Student_Image = student_Image;
    }

    public Bitmap getStudent_Image() {
        return Student_Image;
    }

    public String getSTudent_Name() {
        return STudent_Name;
    }

    public String getStudent_Id() {
        return Student_Id;
    }
}
