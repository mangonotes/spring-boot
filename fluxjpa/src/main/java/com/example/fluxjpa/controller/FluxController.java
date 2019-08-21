package com.example.fluxjpa.controller;

import com.example.fluxjpa.servce.IEventsService;
import com.example.fluxjpa.ui.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flex")
public class FluxController {
    @Autowired
    private IEventsService eventsService;
    @GetMapping(path="/events")
    public Mono<Event> getEvents()
    {
        return eventsService.getEventById(2).defaultIfEmpty(new Event());
    }

}
