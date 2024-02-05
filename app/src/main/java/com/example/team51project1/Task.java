package com.example.team51project1;

public class Task {
    private String taskName;
    private String dueDate;
    private String associatedCourse;

    public Task(String taskName, String dueDate, String associatedCourse) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.associatedCourse = associatedCourse;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getTaskDueDate(){
        return dueDate;
    }

    public String getTaskCourse(){
        return associatedCourse;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public void setTaskDueDate(String duedate) {
        this.dueDate = duedate;
    }

    public void setTaskCourse(String course) {
        this.associatedCourse = course;
    }

    public String toString(){
        return "Task: " + taskName + "\nDue Date: " + dueDate + "\nCourse: " + associatedCourse;

    }
}
