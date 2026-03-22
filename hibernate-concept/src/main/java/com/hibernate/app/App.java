package com.hibernate.app;

import com.hibernate.entities.Certificate;
import com.hibernate.entities.StudentAddress_Entity;
import com.hibernate.entities.Student_Entity;
import com.hibernate.utils.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.util.Date;

public class App {

    public static void main(String[] args){
        try{

            // getSessionFactory => Session => Transaction
            SessionFactory sessionFactory = Utility.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();



            //Student_Entity 's Object => persist :: from java object convert it into table's column
            Student_Entity S1 = new Student_Entity();
            S1.setName("Ram Charan");
            S1.setAge(21);
            S1.setGrades('A');

            Certificate certificate = new Certificate();
            certificate.setCourse("Java Full Stack");
            certificate.setDuration("5 Months");

            S1.setCertificate(certificate);
            session.persist(S1);


            //StudentAddress_Entity 's Object => persist :: from java object convert it into table's column
            StudentAddress_Entity SAE1 = new StudentAddress_Entity();
            SAE1.setStreetNo(101);
            SAE1.setCity("Pune");
            SAE1.setOpen(true);
            SAE1.setX(100.02);
            SAE1.setAddedDate(new Date());

            // For Image
            FileInputStream fis = new FileInputStream("hibernate-concept/src/main/pic.jpg");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            SAE1.setImage(data);

            session.persist(SAE1);




            //Commit :: Transaction => close :: session
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
