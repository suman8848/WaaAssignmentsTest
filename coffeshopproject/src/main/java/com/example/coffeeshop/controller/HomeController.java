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
@SessionAttributes("currentuser")
public class HomeController {

	@Autowired
	PersonService personService;

	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "home";
	}

	@GetMapping({"/secure"})
	public ModelAndView securePage(Model model) {

		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		Person p =personService.findByEmail(name);
		if(p!=null) {
			model.addAttribute("currentuser", p.getEmail());
			modelAndView.addObject("personObj", p.getEmail());
		}else if(name.equals("admin")) {
			modelAndView.addObject("personObj", name);
			model.addAttribute("currentuser", name);
		}

		modelAndView.setViewName("secure");

		return modelAndView;

//		return "secure";
	}
}
/*
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(personService.findByEmail(name)!=null ){
			System.out.println("YAY I am in");
			return "secure";
		}else {
//		String password = auth.get
			//get logged in username
			System.out.println("invalid username");
			return "redirect:/login";
		}
 */