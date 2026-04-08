package com.trumio.model;


//HttpServletRequest-> Employee.java(Model) register.jsp(view - input) Controller: RegistrationController.java View (Output): welcome.jsp

public class Employee {
    private String empId;
    private String name;

    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

