package com.example.aadi.praticeapp;

/**
 * Created by aadi on 10/3/16.
 */
public class RoutineDataModel {

public String Course;
    public String CourseName;
    public String Batch;
    public String Faculty;
    public String RoomNumber;

    public RoutineDataModel(String course, String courseName, String batch, String faculty, String roomNumber) {
        Course = course;
        CourseName = courseName;
        Batch = batch;
        Faculty = faculty;
        RoomNumber = roomNumber;
    }

    public String getCourse() {

        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }
}
