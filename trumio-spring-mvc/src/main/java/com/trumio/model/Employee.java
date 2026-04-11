package com.trumio.model;


//HttpServletRequest-> Employee.java(Model) register.jsp(view - input) Controller: RegistrationController.java View (Output): welcome.jsp

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private String empId;
    private String name;

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

