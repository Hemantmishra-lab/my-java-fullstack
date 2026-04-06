package com.trumio.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelpController {

    @RequestMapping("/help")
    public ModelAndView getHelp() {
        // 1. new object creation of ModelAndView (Container)
        ModelAndView modelAndView = new ModelAndView();

        // 2. Data add (By addObject method )
        modelAndView.addObject("name", "Hemant Mishra");
        modelAndView.addObject("rollNo", 21);

        // Complex object (Current Date & Time) send
        LocalDateTime now = LocalDateTime.now();
        modelAndView.addObject("time", now);

        // List also for practise purpose
        List<Integer> marks = new ArrayList<>();
        marks.add(95);
        marks.add(88);
        marks.add(92);
        modelAndView.addObject("userMarks", marks);

        // 3. View (JSP) name set
        modelAndView.setViewName("help");

        // 4. Whole "Packaged Box" return
        return modelAndView;
    }
}