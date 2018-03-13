package com.example.coffeeshop.service;

import java.util.List;

import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.Role;
import com.example.coffeeshop.domain.User;
import com.example.coffeeshop.repository.PersonRepository;
import com.example.coffeeshop.repository.RoleRepository;
import com.example.coffeeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

//	public Person findByEmail(String email) {
//		return personRepository.findByEmail(email);
//	}
public Person updatePerson(Person person) {
	List<User> users = userRepository.findByEmailAllIgnoreCase(person.getEmail());
//	System.out.println("USERSSSS++++)>>>>>>" + users + users.size());
	User user = null;
	if (users.size() == 1) {
		System.out.println("USERRRRRR++++++>>>"+user);
		user = users.get(0);
		System.out.println("USERRRRRR++++++>>>"+user);
	} else {
		user = new User();
	}

	Role role = roleRepository.findOne(person.getRole());
	System.out.println("ROLEEEE>>>>="+role);
	user.setEmail(person.getEmail());
	user.setPassword(person.getPassword());

	user.addRole(role);
	System.out.println("PERSON>>>ROLE>>"+role);
	user.setEnabled(person.isEnable());
	userRepository.save(user);
	System.out.println("USERREPOSITORY"+userRepository.findAll());
	return personRepository.save(person);
}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public List<Person> getAllPerson() {
		return personRepository.findByEnable(true);
	}
	public List<Person> getAll(){
		return personRepository.findAll();
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

}
