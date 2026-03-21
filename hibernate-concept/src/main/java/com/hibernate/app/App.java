package com.hibernate.app;

import com.hibernate.entities.Student_Entity;
import com.hibernate.utils.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args){
        try{
            SessionFactory sessionFactory = Utility.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Student_Entity S1 = new Student_Entity();
            S1.setName("Ram Charan");
            S1.setAge(21);
            S1.setGrades('A');

            session.persist(S1);
            tx.commit();
            session.close();
            System.out.println("Data has been added to the database");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Data has not been  added to the database");
        }
    }
}
