package com.example.fluxjpa.servce;

import com.example.fluxjpa.dao.EventRepository;
import com.example.fluxjpa.dao.entity.EventEntity;
import com.example.fluxjpa.ui.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;
@Service
public class EventsService implements IEventsService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Mono<Event> getEventById(int id) {
        return Mono.<Event>create(s -> {
            System.out.println("started enquiry::");
            final Optional<EventEntity> tbEvent = eventRepository.findById(id);
            if (tbEvent.isPresent()) {
                Event uiEvent = tbEvent.map(eventDao -> {
                    Event event = new Event();
                    event.setCreatedBy(eventDao.getCreatedBy());
                    event.setCreatedDate(eventDao.getModifiedDt());
                    event.setEventDescription(eventDao.getEventDescription());
                    event.setEventName(eventDao.getEventName());
                    return event;
                }).get();
                s.success(uiEvent);
            } else {
                s.error(new RuntimeException("Event  is empty"));

            }
        }).retryWhen(repeat -> repeat.zipWith(Flux.range(1, 10), (t1, t2) -> t2)
                .flatMap(time -> Mono.delay(Duration.ofSeconds(1)))).log();
    }
}
