package com.trumio.DAO;

import com.trumio.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();


        currentSession.merge(student);

        currentSession.flush();
    }
}


