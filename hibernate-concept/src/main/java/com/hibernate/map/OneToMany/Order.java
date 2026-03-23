package com.hibernate.map.OneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "order_name")
    private String order_name;

    // Many Orders belong to One Customer
    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    public Order() {}

    // Getters and Setters
    public int getOrder_id() { return order_id; }
    public void setOrder_id(int order_id) { this.order_id = order_id; }
    public String getOrder_name() { return order_name; }
    public void setOrder_name(String order_name) { this.order_name = order_name; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}