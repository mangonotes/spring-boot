package org.sony.jpa.demo.controller;

import org.sony.jpa.demo.services.customer.ITicketService;
import org.sony.jpa.demo.ui.dto.TravellerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TicketController {
    private final ITicketService ticketService;

    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/getTravellerList")
    public ResponseEntity<List<TravellerDTO>> getTravellerList()
    {
    return new ResponseEntity<List<TravellerDTO>>(ticketService.getAllTraveller(), HttpStatus.ACCEPTED);
    }
}
