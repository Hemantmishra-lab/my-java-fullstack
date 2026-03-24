package com.hibernate.map.ManyToMany;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")

public class Course {

    @Id
    @Column(name = "Course_id")
    private int Course_id;

    @Column(name = "Couse_name")
    private String Course_name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(int course_id) {
        Course_id = course_id;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
