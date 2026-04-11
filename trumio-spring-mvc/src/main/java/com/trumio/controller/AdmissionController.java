package com.trumio.controller;



import com.trumio.model.Student;
import com.trumio.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AdmissionController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/admission")
    public String showForm() {
        return "admission-form";
    }

    @RequestMapping("/processAdmission")
    public String handleForm(
            @RequestParam("sId") int id,
            @RequestParam("sName") String name,
            @RequestParam("sCourse") String course,
            @RequestParam("sSubjects") List<String> subjects,
            Model model) {

        // Model Object creation
        Student studentObj = new Student(id, name, course, subjects);

        // Saving to DB via Service
        studentService.registerStudent(studentObj);

        // Adding to Spring Model for View
        model.addAttribute("st", studentObj);

        return "confirm-page";
    }
}