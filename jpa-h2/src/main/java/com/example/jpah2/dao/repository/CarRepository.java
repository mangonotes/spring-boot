package com.example.jpah2.dao.repository;

import com.example.jpah2.dao.entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarRepository  implements  IRepository<Car>{
    @PersistenceContext
    private EntityManager entityManager;

    public Car save(Car car){
        entityManager.persist(car);
        return car;
    }
}
