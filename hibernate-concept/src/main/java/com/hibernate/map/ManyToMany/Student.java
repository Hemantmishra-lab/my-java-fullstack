package com.hibernate.map.ManyToMany;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "m2m_student")
public class Student {

    @Id
    @Column(name = "Student_Id")
    private int Student_Id;

    @Column(name = "Student_Name")
    private String Student_Name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = { @JoinColumn(name = "s_id") },
            inverseJoinColumns = { @JoinColumn(name = "c_id") }
    )
    private List<Course> courses;

    public Student() {
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
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
