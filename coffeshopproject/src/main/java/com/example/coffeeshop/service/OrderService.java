package com.example.coffeeshop.service;

import java.util.Date;
import java.util.List;

import com.example.coffeeshop.domain.Order;
import com.example.coffeeshop.domain.Orderline;
import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.Product;
import com.example.coffeeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(Order order){
		return orderRepository.save(order);
	}
	
	public void delete(Order order){
		orderRepository.delete(order);
	}
	
	public List<Order> findByProduct(Product product) {
		return orderRepository.findDistinctOrderByOrderLines_Product(product);
	}
	
	public List<Order> findByPerson(Person person) {
		return orderRepository.findOrderByPerson(person);
	}

	public List<Order> findByDate(Date minDate, Date maxDate) {
		return orderRepository.findOrderByOrderDateBetween(minDate, maxDate);
	}

	public Order findById(int id){
		return orderRepository.findOne(id);
	}

	public List<Order> findAll(){
		return orderRepository.findAll();
	}



}
