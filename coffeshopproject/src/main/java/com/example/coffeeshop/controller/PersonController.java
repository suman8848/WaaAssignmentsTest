package com.example.coffeeshop.controller;


import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.User;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    /*
    Listing products with the help of service
    and sending it to the view
     */
    @GetMapping({"/person/persons"})
    public String listPerson(Model model) {
        model.addAttribute("persons", personService.getAll());
        System.out.println(personService.getAll());
        return "persons";
    }

    @GetMapping({"/person/addPerson"})
    public String addPerson(@ModelAttribute("person") Person person) {
        return "addPerson";
    }

    @PostMapping({"person/addPerson"})
    public String addPerson(Model model, Person person) {
        System.out.println("AddPerson::: "+person);
        personService.savePerson(person);
        return "redirect:/person/persons";

    }

    @GetMapping({"/person/personDetail/{id}"})
    public String getPersonDetail(@PathVariable long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        System.out.println("Value :"+model);
        return "personDetails";
    }

    @PostMapping({"/person/personDetail/{id}"})
    public String updatePerson(@PathVariable long id, Person personDetails){
        Person person= personService.findById(id);
        System.out.println(" i am in update "+id + "person" + person);
        person.setAddress(personDetails.getAddress());
        person.setEmail(personDetails.getEmail());
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setPhone(personDetails.getPhone());
        person.setEnable(personDetails.isEnable());
        personService.savePerson(person);
        return "redirect:/";
    }

    @PostMapping({"/person/deletePerson/{id}"})
    public String deletePerson(@PathVariable long id){
        Person person = personService.findById(id);
        System.out.println(" i am in delete "+id + "product" + person);
        personService.removePerson(person);
        return "redirect:/person/persons";
    }

}
