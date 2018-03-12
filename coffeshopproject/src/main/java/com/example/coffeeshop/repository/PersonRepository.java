package com.example.coffeeshop.repository;


import java.util.List;

import com.example.coffeeshop.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

///**/	public Person findByEmail(String email);

	public List<Person> findByEmail(String email);
	public List<Person> findByEnable(boolean enable);


}
