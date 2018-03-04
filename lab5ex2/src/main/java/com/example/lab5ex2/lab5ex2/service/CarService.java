package com.example.lab5ex2.lab5ex2.service;

import com.example.lab5ex2.lab5ex2.dao.CarDao;
import com.example.lab5ex2.lab5ex2.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {

    @Autowired
    CarDao carDao;

    public List<Car> getAll(){return carDao.getAll();};

    public  void add(Car car){carDao.add(car);};

    public Car get(int id){return carDao.get(id);};

    public  void update(int carId, Car car){carDao.update(carId,car);};

    public  void delete(int carId){carDao.delete(carId);};
}
