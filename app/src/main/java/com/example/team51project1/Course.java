package com.example.team51project1;

public class Course {
    private String courseName;
    private String time;
    private String daysOfWeek;
    private String teacherName;
    private String section;
    private String building;
    private int roomNumber;

    public Course(String courseName, String teacherName, String building, String daysOfWeek, String time) {
        this.courseName = courseName;
        this.time = time;
        this.teacherName = teacherName;
        this.daysOfWeek = daysOfWeek;
        this.building = building;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseTime(){

        return time;
    }

    public String getCourseTeacher(){

        return teacherName;
    }

    public String getCourseDaysOfWeek(){
        return daysOfWeek;
    }

    public int getCourseRoomNumber(){

        return roomNumber;
    }

    public String getCourseSection(){

        return section;
    }
    public String getCourseBuilding(){

        return building;
    }

    public void setCourseName(String courseName){

        this.courseName = courseName;
    }

    public void setCourseTime(String time){

        this.time = time;
    }

    public void setCourseTeacher(String teacher){

        this.teacherName = teacher;
    }

    public void setCourseDaysOfWeek(String daysOfWeek){
        this.daysOfWeek = daysOfWeek;
    }

    public void setCourseRoomNumber(int roomNumber){

        this.roomNumber = roomNumber;
    }

    public void setCourseSection(String section){

        this.section = section;
    }
    public void setCourseBuilding(String building){

        this.building = building;
    }

    public String toString() {
        //return "You are in " + courseName + " with Professor " + teacherName + " in " + building + " at " + time;
        return "Course/Section: " + courseName + "\nTime: " + time + "\nInstructor: " + teacherName + "\nLocation: " + building;
    }



}
