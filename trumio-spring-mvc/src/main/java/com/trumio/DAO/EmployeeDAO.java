package com.trumio.DAO;

import com.trumio.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void SaveEmployee(Employee employee){

        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
        session.flush();
    }
}
