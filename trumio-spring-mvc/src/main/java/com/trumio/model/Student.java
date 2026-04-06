package com.trumio.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String course;
    private List<String> subjects;

    // Constructors, Getters and Setters
    public Student(int id, String name, String course, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subjects = subjects;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public List<String> getSubjects() { return subjects; }
}