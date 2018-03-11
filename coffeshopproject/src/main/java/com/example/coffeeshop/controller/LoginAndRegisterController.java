package com.example.coffeeshop.controller;

import com.example.coffeeshop.domain.Authorities;
import com.example.coffeeshop.domain.User;
import com.example.coffeeshop.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginAndRegisterController {

    @Autowired
    AuthorityService authorityService;
//    @Autowired
//    UserService userService;


    @GetMapping({"/login"})
    public String showLoginPage(){
        return "login" ;
    }

    @PostMapping({"/login"})
    public String checkLogin( Authorities authorities){
        System.out.println("i am here");
        User user = authorities.getUser();
        System.out.println(user);
        return null;
    }


    @GetMapping({"/register"})
    public String showRegisterPage(){
        //System.out.println("i am in register controller");
        return "register";
    }
}
