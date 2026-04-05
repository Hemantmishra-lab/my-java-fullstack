package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args){


        try{
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            
        }
        catch(Exception e){

            e.printStackTrace();
        }
    }
}
