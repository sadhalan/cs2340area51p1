package com.example.team51project1;

public class Assignment {
    private String assignmentName;
    private String dueDate;
    private String associatedCourse;

    public Assignment(String assignmentName, String dueDate, String associatedCourse) {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.associatedCourse = associatedCourse;
    }

    public String getAssignmentName(){
        return assignmentName;
    }

    public String getAssignmentDueDate(){
        return dueDate;
    }

    public String getAssignmentCourse(){
        return associatedCourse;
    }

    public void setAssignmentName(String name) {
        this.assignmentName = name;
    }

    public void setAssignmentDueDate(String duedate) {
        this.dueDate = duedate;
    }

    public void setAssociatedCourse(String course) {
        this.associatedCourse = course;
    }

    public String toString(){
        return "Assignment: " + assignmentName + "\nDue Date: " + dueDate + "\nCourse: " + associatedCourse;

    }


}
