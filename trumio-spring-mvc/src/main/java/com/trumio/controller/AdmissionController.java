package com.trumio.controller;

import com.trumio.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AdmissionController {

    @RequestMapping("/admission")
    public String showForm() {
        return "admission-form";
    }

    @RequestMapping("/processAdmission")
    public String handleForm(
            @RequestParam("sId") int id,
            @RequestParam("sName") String name,
            @RequestParam("sCourse") String course,
            @RequestParam("sSubjects") List<String> subjects, // List automatically handle hogi
            Model model) {

        // 1. Aapki existing class ka object banana using constructor
        Student studentObj = new Student(id, name, course, subjects);

        // 2. Pure object ko Model mein dalna
        model.addAttribute("st", studentObj);

        return "confirm-page";
    }
}