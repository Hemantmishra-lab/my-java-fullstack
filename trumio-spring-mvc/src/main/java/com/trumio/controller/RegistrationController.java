package com.trumio.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//HttpServletRequest-> Employee.java(Model) register.jsp(view - input) Controller: RegistrationController.java View (Output): welcome.jsp

@Controller
public class RegistrationController {


    @RequestMapping("/register")
    public String showForm() {
        return "register"; // Yeh 'register.jsp' ko dhoondega
    }


    @RequestMapping("/saveEmployee")
    public String register(HttpServletRequest request, Model model) {

        // From jsp data extract the name attribute
        String id = request.getParameter("f_id");
        String name = request.getParameter("f_name");

        // Add data in Model so we can see in welcome.jsp page
        model.addAttribute("displayId", id);
        model.addAttribute("displayName", name);

        return "welcome"; // refers to welcome.jsp
    }
}