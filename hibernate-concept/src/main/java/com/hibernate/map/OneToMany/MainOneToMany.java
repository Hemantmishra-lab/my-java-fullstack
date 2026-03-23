package com.hibernate.map.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class MainOneToMany {

    public static void main(String [] args){
        try {
            //Creation of SessionFactory
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            //Creation of Session
            Session session = sessionFactory.openSession();
            //Transaction begin
            Transaction tx = session.beginTransaction();

            // 1. Create Customer
            Customer customer = new Customer();
            customer.setCustomer_id(654);
            customer.setCustomer_name("Ram Babu");

            // 2. Create Multiple Orders
            Order o1 = new Order();
            o1.setOrder_id(123);
            o1.setOrder_name("Water Bottle");
            o1.setCustomer(customer); // Link order to customer

            Order o2 = new Order();
            o2.setOrder_id(124);
            o2.setOrder_name("Laptop Bag");
            o2.setCustomer(customer); // Link order to customer

            // 3. Add Orders to the Customer's List
            List<Order> orderList = new ArrayList<>();
            orderList.add(o1);
            orderList.add(o2);
            customer.setOrders(orderList);

            // 4. Persist
            // Because of cascade = CascadeType.ALL, saving customer will save orders too
            session.persist(customer);

            tx.commit();
            session.close();
            sessionFactory.close();
            System.out.println("Customer and Orders saved!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}