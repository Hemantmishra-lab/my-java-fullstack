package com.hibernate.map.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course{

    @Id
    @Column(name = "Course_Id")
    private int Course_Id;

    @Column(name = "Course_Name")
    private String Course_Name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public int getCourse_Id() {
        return Course_Id;
    }

    public void setCourse_Id(int course_Id) {
        Course_Id = course_Id;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}