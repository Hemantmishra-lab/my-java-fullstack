package com.hibernate.app;

import com.hibernate.entities.StudentAddress_Entity;
import com.hibernate.entities.Student_Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo{
    public static void main(String[] args){
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();

            com.hibernate.entities.Student_Entity studentEntity = session.find(Student_Entity.class, 3);
            if(studentEntity != null){
                System.out.println(studentEntity);
            }
            else{
                System.out.println("There is not any row for id = 3");
            }

            StudentAddress_Entity studentAddressEntity = session.find(StudentAddress_Entity.class,101);
            if(studentAddressEntity != null){
                System.out.println(studentAddressEntity);
            }
            else{
                System.out.println("Data not found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}