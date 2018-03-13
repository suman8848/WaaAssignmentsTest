package com.example.coffeeshop.controller;

import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping({"/", "/index", "/home"})
    public String homePage(Model model) {
        return "redirect:/product/lunch";
    }
}