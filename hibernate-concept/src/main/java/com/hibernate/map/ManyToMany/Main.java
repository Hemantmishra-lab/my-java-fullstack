package com.hibernate.map.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Course c1 = new Course();
            c1.setCourse_id(1);
            c1.setCourse_name("Java, Python");

            Course c2 = new Course();
            c2.setCourse_id(2);
            c2.setCourse_name("JavaScript, C++");

            List<Course> courseList = new ArrayList<>();
            courseList.add(c1);
            courseList.add(c2);

            Student s1 = new Student();
            s1.setStudent_Id(101);
            s1.setStudent_Name("Ram");
            s1.setCourses(courseList);

            Student s2 = new Student();
            s2.setStudent_Id(102);
            s2.setStudent_Name("Charan");
            s2.setCourses(courseList);

            session.persist(s1);
            session.persist(s2);

            tx.commit();
            session.close();
            sessionFactory.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
