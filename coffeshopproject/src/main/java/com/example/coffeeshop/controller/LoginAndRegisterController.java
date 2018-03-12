package com.example.coffeeshop.controller;

import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginAndRegisterController {


//    @Autowired
//    UserService userService;


    @GetMapping({"/user/login"})
    public String showLoginPage(@ModelAttribute("person") Person person){
        return "login" ;
    }



    @GetMapping({"/register"})
    public String showRegisterPage(){
        //System.out.println("i am in register controller");
        return "register";
    }
}
