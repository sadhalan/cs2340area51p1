package com.example.team51project1;

public class Assignment {
    private String assignmentName;
    private int dueDate;
    private Course associatedCourse;

    public Assignment(String assignmentName, int dueDate, Course associatedCourse) {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.associatedCourse = associatedCourse;
    }

    public String getCourseName(){
        return assignmentName;
    }

    public int getAssignmentDueDate(){
        return dueDate;
    }

    public Course getAssignmentCourse(){
        return associatedCourse;
    }

/*
    public String toString(){
        return ""
    }
*/


}
