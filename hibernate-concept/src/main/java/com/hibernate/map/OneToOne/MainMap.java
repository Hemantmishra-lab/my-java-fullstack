package com.hibernate.map.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMap{

    public static void main(String[] args){

        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();

            Question q1 = new Question();
            q1.setQuestion_id(1216);
            q1.setQuestion("What is Java?");

            Answer ans = new Answer();
            ans.setAnswer("Java is a programming language");
            ans.setAnswer_id(343);

            q1.setAnswer(ans);
            session.persist(q1);
            session.persist(ans);
            tx1.commit();
            session.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}