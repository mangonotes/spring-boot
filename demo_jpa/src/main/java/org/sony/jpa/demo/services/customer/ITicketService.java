package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.ui.dto.TravellerDTO;

import java.util.List;

public interface ITicketService {
    List<TravellerDTO> getAllTraveller();
    void insertTraveller(TravellerDTO travellerDTO);
}
