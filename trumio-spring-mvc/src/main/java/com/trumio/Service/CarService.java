package com.trumio.Service;

import com.trumio.DAO.BookDAO;
import com.trumio.DAO.CarBookingDAO;
import com.trumio.model.CarBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    private CarBookingDAO carBookingDAO;

    @Transactional
    public void registerCar(CarBooking carBooking){
        //Business Logic here
        carBookingDAO.saveCar(carBooking);
    }
}
