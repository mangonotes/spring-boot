package com.example.fluxjpa.servce;

import com.example.fluxjpa.ui.Event;
import reactor.core.publisher.Mono;

public interface IEventsService {
    Mono<Event> getEventById(int id);
}
