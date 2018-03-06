package com.example.lab7.demolab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {


    @RequestMapping(value = "/", method =RequestMethod.GET)
    public String welcome(Model model){
        System.out.println("I am here in index controller ");
//        model.addAttribute("data","hello suman welcome");
        return "teamlist";
    }

}
