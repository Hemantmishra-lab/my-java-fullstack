package com.trumio.model;

import java.util.List;


//RegistrationController.java -> Model: Student.java -> View (Input): admission-form.jsp -> Controller: AdmissionController.java -> View (Output): confirm-page.jsp


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Baccha")
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    @ElementCollection
    @CollectionTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"))
    private List<String> subjects;

    public Student() {} // Required by Hibernate

    public Student(int id, String name, String course, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subjects = subjects;
    }

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}