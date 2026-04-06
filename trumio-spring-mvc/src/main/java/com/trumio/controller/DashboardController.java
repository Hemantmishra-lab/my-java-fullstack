package com.trumio.controller;

import com.trumio.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView mv = new ModelAndView();

        // Creating a professional student object
        Student student = new Student(101, "Hemant Mishra", "B.Tech CSE",
                Arrays.asList("Java Fullstack", "Spring MVC", "Cloud Computing"));

        // Adding data to ModelAndView
        mv.addObject("student", student);
        mv.addObject("status", "Active");

        // Setting the view name
        mv.setViewName("dashboard");
        return mv;
    }
}