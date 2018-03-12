package com.example.coffeeshop.config;

import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class AuthenticationListener implements ApplicationListener<AuthenticationSuccessEvent>{

	@Autowired
	HttpSession session;
	
	@Autowired
	PersonService service;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		System.out.println(event.getAuthentication().getName() + " logged successully");
		List<Person> persons = service.findByEmail(event.getAuthentication().getName());
		if (persons.size() == 1) {
			session.setAttribute("loggedUser", persons.get(0));
		}
	}

}
