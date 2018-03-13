package com.example.coffeeshop.controller;

import com.example.coffeeshop.config.SessionHandlerListener;
import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.User;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/")
public class UserAccountController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PersonService personService;


    @Autowired
    private UserService userService;

    @Autowired
    private SessionHandlerListener sessionListener;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping({"order"})
    public String order(Model model) {
        Person person = sessionListener.getPerson();
        model.addAttribute("previousOrder", orderService.findByPerson(person));
        return "orderLineList";
    }

    // Update Account
    @GetMapping({"/account/update"})
    public String account(Model model) {
        Person updatedPerson = personService.findById(sessionListener.getPerson().getId());
        User user = userService.findByEmail(updatedPerson.getEmail());
        if (user.getRoles().size() >= 1) {
            updatedPerson.setRole(user.getRoles().get(0).getId());
        }
        System.out.println("UPDATED PERSON___>>>>" + updatedPerson);
        model.addAttribute("user", updatedPerson);
        return "account";
    }

    //    @PostMapping("/account/update")
//    public String updateAccount(Model model, @ModelAttribute("user")  Person person) {
//        System.out.println("PERSONNNNN____--->>"+person);
//        User user = userService.findByEmail(person.getEmail());
//        if (person.getPassword() != null && !person.getPassword().isEmpty()) {
//            person.setPassword(encoder.encode(person.getPassword()));
//        } else {
//            person.setPassword(user.getPassword());
//        }
//        personService.savePerson(person);
//
//        return "redirect:/";
//    }
//    @PutMapping({"/account/update"})
//    public String updatePerson(Model model, @ModelAttribute("user") Person personDetails) {
//        Person person = personService.findById(personDetails.getId());
//        System.out.println(" i am in update " + personDetails.getId() + "person" + person);
//        person.setAddress(personDetails.getAddress());
//        person.setEmail(personDetails.getEmail());
//        person.setFirstName(personDetails.getFirstName());
//        person.setLastName(personDetails.getLastName());
//        person.setPhone(personDetails.getPhone());
//        person.setEnable(personDetails.isEnable());
//        person.setRole(personDetails.getRole());
//        personService.savePerson(person);
//        return "redirect:/";
//    }

    @GetMapping({"/account/signup"})
    public String signUp(Model model, @ModelAttribute("user") Person person) {
        person.setRole(1);
        person.setEnable(true);
        return "register";
    }

    @PostMapping("/account/signup")
    public String createNewAccount(Model model, @ModelAttribute("user") Person person) {
        String view = "register";
        User user = userService.findByEmail(person.getEmail());
        if (user != null) {
            model.addAttribute("errorMessage", "This email already exists. Please use another email.");
            return view;
        }
        if (person.getPassword() != null && !person.getPassword().isEmpty()) {
            person.setPassword(encoder.encode(person.getPassword()));
        }
        personService.savePerson(person);
        model.addAttribute("successMessage", "Your new account has been created sucessfully. Click here to login");
        return view;
    }
}
