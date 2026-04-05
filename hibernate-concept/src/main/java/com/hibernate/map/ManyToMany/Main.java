package com.hibernate.map.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main{


    public static void main(String[] args){

        //Create a SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //From SessionFactory create Session
        Session session = sessionFactory.openSession();
        //Add Transactions
        Transaction tx = session.beginTransaction();
        //Create Objects of The Entity Classes
        Course course = new Course();


        Student student = new Student();

//        session.persist();
//        session.persist();
        tx.commit();
        session.close();

    }
}