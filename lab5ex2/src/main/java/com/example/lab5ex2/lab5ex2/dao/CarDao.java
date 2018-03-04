package com.example.lab5ex2.lab5ex2.dao;

import com.example.lab5ex2.lab5ex2.NoSuchResourceException;
import com.example.lab5ex2.lab5ex2.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarDao {
	private static int idCount = 1;
	protected Map<Integer, Car> cars = new HashMap();
	
	public CarDao() {
		add(new Car("Volvo", "S80", 1999, "Silver"));
		add(new Car("Honda", "Accord", 1997, "Red"));
	}
	
	public List<Car> getAll() {
		return new ArrayList<Car>(cars.values());
	}
	
	public void add(Car car) {
		car.setId(idCount);
		cars.put(idCount, car);
		idCount++;
	}
	
	public Car get(int id) {
		Car result = cars.get(id);
		
		if (result == null) {
			throw new NoSuchResourceException("Car", id);
		}
		
		return result;
	}
	
	public void update(int carId, Car car) {
		cars.put(carId, car);
	}
	
	public void delete(int carId) {
		Car removed = cars.remove(carId);
		if (removed == null) {
			throw new NoSuchResourceException("Car", carId);
		}
	}
}
