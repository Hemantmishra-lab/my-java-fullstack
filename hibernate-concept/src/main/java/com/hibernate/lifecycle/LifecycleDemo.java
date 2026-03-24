package com.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifecycleDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // 1. Transient State
            StudentLifeCycle studentLifeCycle = new StudentLifeCycle();
            studentLifeCycle.setId(101);
            studentLifeCycle.setName("Aryan");

            // 2. Persistent State
            session.persist(studentLifeCycle);

            // Hibernate tracks this change automatically
            studentLifeCycle.setName("Aryan Sharma");

            tx.commit();
            session.close(); // Moving to Detached State

            // 3. Detached State
            studentLifeCycle.setName("This change won't be saved");

            // 4. Removed State
            Session session2 = sessionFactory.openSession();
            Transaction tx2 = session2.beginTransaction();

            // CORRECTION: Use ID 101 (the one we just saved) instead of 105
            StudentLifeCycle Temp_studentLifeCycle1 = session2.find(StudentLifeCycle.class, 101);

            // CORRECTION: Safety check to avoid "Entity may not be null" error
            if (Temp_studentLifeCycle1 != null) {
                session2.remove(Temp_studentLifeCycle1);
                tx2.commit();
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found!");
            }

            session2.close();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}