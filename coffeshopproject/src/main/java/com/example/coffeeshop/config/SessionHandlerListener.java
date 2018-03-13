package com.example.coffeeshop.config;

import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component("sessionListener")
public class SessionHandlerListener {

	@Autowired
	PersonService service;

	@Autowired
	HttpSession session;
	
	public Person getPerson() {
		if (session.getAttribute("loggedUser") != null) {
			return (Person) session.getAttribute("loggedUser");
		}
		List<Person> persons = service.findByEmail(getPrincipal());
		if (persons.size() == 1) {
			session.setAttribute("loggedUser", persons.get(0));
			return persons.get(0);
		}
		return new Person();
		
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

	
}


