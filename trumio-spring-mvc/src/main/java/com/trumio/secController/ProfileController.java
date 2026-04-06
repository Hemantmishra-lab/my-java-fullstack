package com.trumio.secController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController{


    @RequestMapping("/profile")
    public String getProfile(Model model){

        model.addAttribute("Uname","Hemant Mishra");
        model.addAttribute("UId",12);

        List<String> friends = new ArrayList<>();
        friends.add("Rahul");
        friends.add("Shyam");
        friends.add("Prince Kumar");
        model.addAttribute("fList",friends);


        return "profile";
    }
}
