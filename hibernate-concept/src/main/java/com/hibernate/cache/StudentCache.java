package com.hibernate.cache;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentCache")
public class StudentCache {

    @Id
    @Column(name = "Student_id")
    private int StudentCache_id;

    @Column(name = "StudentName")
    private String StudentCacheName;

    public StudentCache() {
    }

    public int getStudentCache_id() {
        return StudentCache_id;
    }

    public void setStudentCache_id(int studentCache_id) {
        StudentCache_id = studentCache_id;
    }

    public String getStudentCacheName() {
        return StudentCacheName;
    }

    public void setStudentCacheName(String studentCacheName) {
        StudentCacheName = studentCacheName;
    }
}
