package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.User;
import com.example.coffeeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		List<User> users = userRepository.findByEmailAllIgnoreCase(email);
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

}
