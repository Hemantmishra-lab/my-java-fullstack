package com.hibernate.lifecycle;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentLifeCycle {

    @Id
    @Column(name = "student_id")
    private int id;

    @Column(name = "Student_name")
    private String name;

    public StudentLifeCycle() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
