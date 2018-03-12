package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.Role;
import com.example.coffeeshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAll() {
		return roleRepository.findAll();
	}

}
