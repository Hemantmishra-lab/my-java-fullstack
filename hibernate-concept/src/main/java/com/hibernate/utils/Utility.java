package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Utility {

    private static SessionFactory sessionFactory;
    static{
        try{
            if(sessionFactory == null){
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
