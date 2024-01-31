package com.example.team51project1;

public class Course {
    private String courseName;
    private int time;
    private String teacherName;

    public Course(String courseName, int time, String teacherName) {
        this.courseName = courseName;
        this.time = time;
        this.teacherName = teacherName;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getCourseTime(){
        return time;
    }

    public String getCourseTeacher(){
        return teacherName;
    }

/*
    public String toString(){
        return ""
    }
*/


}
