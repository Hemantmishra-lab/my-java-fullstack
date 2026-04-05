package com.hibernate.map.ManyToMany;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m2mStudent")
public class Student{

    @Id
    @Column(name = "Student_Id")
    private int Student_id;

    @Column(name = "Student_Name")
    private String Student_Name;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Student_Course_Join",
            joinColumns = {@JoinColumn(name = "Student_Id")},
            inverseJoinColumns = {@JoinColumn(name = "Course_Id")}
    )
    private List<Course> courses;

    public Student() {
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}