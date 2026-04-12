package com.trumio.controller;



import com.trumio.model.Student;
import com.trumio.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;//this is import important



// with Redirect prefix total request = 2
@Controller
public class AdmissionController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/admission")
    public String showForm() {
        return "admission-form";
    }

    @PostMapping("/processAdmission")
    public String handleForm(
            @RequestParam("sId") int id,
            @RequestParam("sName") String name,
            @RequestParam("sCourse") String course,
            @RequestParam("sSubjects") List<String> subjects,
            RedirectAttributes redirectAttributes) { //Instead of using Model ue RedirectAttribute interface of spring mvc

        // 1. Create the Object
        Student studentObj = new Student(id, name, course, subjects);

        // 2. Save in the Database
        studentService.registerStudent(studentObj);

        // 3. Adding Flash Attribute(Magic)
        // Put the name as "st" so we can extract in jsp
        redirectAttributes.addFlashAttribute("st", studentObj);

        // 4. Redirect in new URL
        return "redirect:/admission-success";
    }

    // New Handler after redirecting
    @RequestMapping("/admission-success")
    public String showSuccessPage() {
        //Here 'st'  will be found in the model automatically due to the spring
        return "confirm-page";
    }
}



//without any redirect total request = 1
//@Controller
//public class AdmissionController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @RequestMapping("/admission")
//    public String showForm() {
//        return "admission-form";
//    }
//
//    @RequestMapping("/processAdmission")
//    public String handleForm(
//            @RequestParam("sId") int id,
//            @RequestParam("sName") String name,
//            @RequestParam("sCourse") String course,
//            @RequestParam("sSubjects") List<String> subjects,
//            Model model) {
//
//        // Model Object creation
//        Student studentObj = new Student(id, name, course, subjects);
//
//        // Saving to DB via Service
//        studentService.registerStudent(studentObj);
//
//        // Adding to Spring Model for View
//        model.addAttribute("st", studentObj);
//
//        return "confirm-page";
//    }
//}
