package com.example.jpah2.dao.repository;

import com.example.jpah2.dao.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarRepositoryTest {
    @Autowired
private IRepository<Car> carRepository;
    @Test
    @Transactional
    public void testCarInsert(){
       Car car= carRepository.save(createCar());
       assertNotNull(car.getId());
    }
    private Car createCar(){
        Car car = new Car();
        car.setName("First entry");
        return car;
    }
}