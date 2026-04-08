package com.trumio.controller;

import com.trumio.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


//<!-- RegistrationController.java -> Model: Student.java -> View (Input): admission-form.jsp -> Controller: AdmissionController.java -> View (Output): confirm-page.jsp -->
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


        Student studentObj = new Student(id, name, course, subjects);


        model.addAttribute("st", studentObj);

        return "confirm-page";
    }
}