package com.trumio.Service;

import com.trumio.DAO.EmployeeDAO;
import com.trumio.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    public void registerEmployee(Employee employee){

        //Business Logic code
        employeeDAO.SaveEmployee(employee);
    }
}
