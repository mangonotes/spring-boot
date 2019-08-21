package com.example.fluxjpa;

import com.example.fluxjpa.dao.EventRepository;
import com.example.fluxjpa.dao.entity.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class FluxjpaApplication {
	@Autowired
    private EventRepository eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(FluxjpaApplication.class, args);
    }

    @PostConstruct
    public void dataSetup() {
		EventEntity eventEntity = new EventEntity();
		eventEntity.setEventName("Testing Event");
		eventEntity.setEventDescription("Its starting events....");
		eventEntity.setCreatedDt(new Date());
		eventEntity.setId(1);
		eventEntity.setCreatedBy("Admin");
		eventRepository.save(eventEntity);
		Optional<EventEntity> event= eventRepository.findById(1);
		if (event.isPresent()) {
			System.out.println("id 1 available " +event.get().getEventDescription());
		}
    }
}
