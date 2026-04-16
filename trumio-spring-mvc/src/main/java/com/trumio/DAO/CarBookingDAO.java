package com.trumio.DAO;

import com.trumio.model.CarBooking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarBookingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCar(CarBooking carBooking){

        Session session = sessionFactory.getCurrentSession();
        session.merge(carBooking);
        session.flush();
    }
}
