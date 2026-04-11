package com.trumio.controller;

import com.trumio.Service.EmployeeService;
import com.trumio.model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//HttpServletRequest-> Employee.java(Model) register.jsp(view - input) Controller: RegistrationController.java View (Output): welcome.jsp

@Controller
public class RegistrationController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/register")
    public String showForm() {
        return "register";
    }


    @RequestMapping("/saveEmployee")
    public String register(HttpServletRequest request, Model model) {


        // From jsp data extract the name attribute
        String id = request.getParameter("f_id");
        String name = request.getParameter("f_name");

        //save the data in the database
        Employee employee = new Employee(id,name);
        employeeService.registerEmployee(employee);

        // Add data in Model so we can see in welcome.jsp page
        model.addAttribute("displayId", id);
        model.addAttribute("displayName", name);

        return "welcome"; // refers to welcome.jsp
    }
}