package com.example.coffeeshop.repository;

import java.util.Date;
import java.util.List;

import com.example.coffeeshop.domain.Order;
import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findDistinctOrderByOrderLines_Product(Product product);
	List<Order> findOrderByPerson(Person person);
	List<Order> findOrderByOrderDateBetween(Date minDate, Date maxDate);
	

}
