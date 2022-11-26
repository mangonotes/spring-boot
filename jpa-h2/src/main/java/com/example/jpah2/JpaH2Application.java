package com.example.jpah2;

import com.example.jpah2.dao.entity.Car;
import com.example.jpah2.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class JpaH2Application  implements CommandLineRunner {
@Autowired
	private CarRepository carRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaH2Application.class, args);
	}
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Car car = new Car();
		car.setName("Testing");
		carRepository.save(car);

	}
}
