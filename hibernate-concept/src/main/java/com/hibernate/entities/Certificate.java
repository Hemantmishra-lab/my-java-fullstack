package com.hibernate.entities;


import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {

    private String Course;
    private String duration;

    public Certificate() {
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
