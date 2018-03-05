package com.example.lab5ex2.lab5ex2.controller;

import com.example.lab5ex2.lab5ex2.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@ComponentScan("org.springframework.security.samples.mvc")
public class LoginController {


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String home(@ModelAttribute("user") User user) {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user) {
        return "welcome";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(req, resp, auth);
        }
        return "redirect:/login";
    }

//    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
//    public ModelAndView welcomePage() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("welcome");
//        return model;
//    }
//
//    @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
//    public ModelAndView homePage() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("homePage");
//        return model;
//    }
//
//    @RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
//    public ModelAndView userPage() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("userPage");
//        return model;
//    }
//
//    @RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("adminPage");
//        return model;
//    }
//
//    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
//    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
//                                  @RequestParam(value = "logout",	required = false) String logout) {
//
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid Credentials provided.");
//        }
//
//        if (logout != null) {
//            model.addObject("message", "Logged out from JournalDEV successfully.");
//        }
//
//        model.setViewName("loginPage");
//        return model;
//    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return  localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        return resourceBundleMessageSource;
    }
}
