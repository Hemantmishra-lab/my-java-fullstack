package com.hibernate.fetch;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student_Fetch {
    @Id
    private int id;
    private String name;

    // LAZY: Courses are only loaded if you call getCourses()
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<Course_Fetch> cours;

    public Student_Fetch() {
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

    public List<Course_Fetch> getCourses() {
        return cours;
    }

    public void setCourses(List<Course_Fetch> cours) {
        this.cours = cours;
    }
}
