package com.example.test1;

public class Course {
    private String coursename;
    private Double coursefees;
    private int coursehours;

    public Course(String coursename, double coursefees, int coursehours) {
        this.coursename = coursename;
        this.coursefees = coursefees;
        this.coursehours = coursehours;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public double getCoursefees() {
        return coursefees;
    }

    public void setCoursefees(double coursefees) {
        this.coursefees = coursefees;
    }

    public int getCoursehours() {
        return coursehours;
    }

    public void setCoursehours(int coursehours) { this.coursehours = coursehours; }
}
