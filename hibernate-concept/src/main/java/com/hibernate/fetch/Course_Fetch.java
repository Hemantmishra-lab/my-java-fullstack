package com.hibernate.fetch;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_details") // Nombre de la tabla en DB
public class Course_Fetch {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    // Relación inversa: 'mappedBy' indica que la configuración
    // real (JoinTable) está en el campo 'courses' de la clase Student.
    @ManyToMany(mappedBy = "courses")
    private List<Student_Fetch> students;

    // Constructor vacío (Obligatorio para Hibernate)
    public Course_Fetch() {
    }

    // Getters y Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student_Fetch> getStudents() {
        return students;
    }

    public void setStudents(List<Student_Fetch> students) {
        this.students = students;
    }
}