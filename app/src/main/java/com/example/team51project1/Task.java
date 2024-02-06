package com.example.team51project1;

public class Task {
    private String taskName;
    private String associatedCourse;
    private String dueDate;

    private String examTime;

    private String examLocation;

    public Task(String taskName, String associatedCourse, String dueDate, String examTime,
                    String examLocation) {
        this.taskName = taskName;
        this.associatedCourse = associatedCourse;
        this.dueDate = dueDate;
        this.examTime = examTime;
        this.examLocation = examLocation;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getTaskCourse(){
        return associatedCourse;
    }

    public String getTaskDueDate(){
        return dueDate;
    }

    public String getExamTime(){return examTime;}

    public String getExamLocation(){return examLocation;}

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public void setTaskCourse(String course) {
        this.associatedCourse = course;
    }

    public void setTaskDueDate(String duedate) {
        this.dueDate = duedate;
    }

    public void setExamTime(String examTime){this.examTime = examTime;}

    public void setExamLocation(String examLocation){this.examLocation = examLocation;}

    public String toString(){
        if(examTime == null  | examLocation == null | examTime.equals("")
                | examLocation.equals("")){
            return "Task: " + taskName + "\nCourse: " + associatedCourse + "\nDue Date: "
                    + dueDate;
        }
        return "Exam: " + taskName + "\nCourse: " + associatedCourse + "\nDue Date: " + dueDate
                + "\nTime: " + examTime + "\nLocation: " + examLocation;

    }
}
