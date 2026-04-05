package com.hibernate.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // --- STEP 1: FETCHING THE DATA ---
        Session session = factory.openSession();

        // If EAGER: This single line triggers a SQL JOIN and loads everything.
        // If LAZY: This line ONLY loads the Student name and ID.
        Student_Fetch student = session.find(Student_Fetch.class, 101);

        System.out.println("Student Name: " + student.getName());

        // --- STEP 2: ACCESSING COLLECTIONS ---

        // If LAZY: Hibernate fires a second SQL query right HERE to get the courses.
        // If the session was already closed before this line, LAZY will throw a
        // LazyInitializationException.
        System.out.println("Courses: " + student.getCourses().size());

        session.close();
        factory.close();
    }
}
