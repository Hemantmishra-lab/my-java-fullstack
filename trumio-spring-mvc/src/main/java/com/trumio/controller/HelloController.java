package com.trumio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//HelloController.java -> index.jsp

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(org.springframework.ui.Model model) {

        model.addAttribute("serverMessage", "Data sent from Controller successfully!");
        return "index";
    }
}
