package com.hibernate.entities;


import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Student_Address_Table")
public class StudentAddress_Entity {


    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
    @Column(name = "Address_ID")
    private int Address_ID;


    @Column(length = 50 ,name = "STREET NO.")
    private int streetNo;


    @Column(length =100, name = "CITY")
    private String city;


    @Column(name = "isOpen")
    private boolean isOpen;


    @Transient  //Ignore By the @Table (This column will not create in the table)
    private double x;


    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)  //Only date format
    private Date addedDate;


    @Lob  //For long data like image, feedback
    private byte[] image;


    public StudentAddress_Entity() {
    }

    public int getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(int address_ID) {
        Address_ID = address_ID;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
