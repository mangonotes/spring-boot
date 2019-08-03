package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.dao.enitty.TbCustMaster;
import org.sony.jpa.demo.dao.enitty.TbTickets;
import org.sony.jpa.demo.dao.enitty.TbTraveller;
import org.sony.jpa.demo.dao.repository.TicketRepository;
import org.sony.jpa.demo.dao.repository.TravellerRepository;
import org.sony.jpa.demo.ui.dto.CustomerDTO;
import org.sony.jpa.demo.ui.dto.TicketDTO;
import org.sony.jpa.demo.ui.dto.TravellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class TicketService implements ITicketService {
    private TravellerRepository travellerRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(TravellerRepository travellerRepository,  TicketRepository ticketRepository) {
        this.travellerRepository= travellerRepository;
        this.ticketRepository= ticketRepository;
    }

    @Override
    public List<TravellerDTO> getAllTraveller() {
       return travellerRepository.findAllTravellerWithJoin().stream().map(tbTraveller ->
        {
            TravellerDTO travellerDTO = new TravellerDTO();
            travellerDTO.setTickets(tbTraveller.getTbTicketsSet().stream().map(tbTickets -> {
             return   inverseConverter.apply(tbTickets);
            }).collect(Collectors.toList()));
            travellerDTO.setName(tbTraveller.getName());
            travellerDTO.setId(tbTraveller.getTravellerId());
            travellerDTO.setNationality(tbTraveller.getNationality());
            return  travellerDTO;
        }).collect(Collectors.toList());

    }

    @Override
    public void insertTraveller(TravellerDTO travellerDTO) {
        TbTraveller tbTraveller = new TbTraveller();
        tbTraveller.setNationality(travellerDTO.getNationality());
        tbTraveller.setName(travellerDTO.getName());
        tbTraveller.setCreatedBy("Admin");
        tbTraveller.setCreatedDt(new Date());

        TbTraveller    tbTravellerDAO=   travellerRepository.save(tbTraveller);
        travellerDTO.getTickets().forEach(ticketDTO -> {
        TbTickets tbTickets = new TbTickets();
        tbTickets.setTicketPrice(ticketDTO.getTicketPrice());
        tbTickets.setDestination(ticketDTO.getDestination());
        tbTickets.setCreatedBy("Admin");
        tbTickets.setTbTraveller(tbTravellerDAO);
        tbTickets.setCreatedDt(new Date());
        ticketRepository.save(tbTickets);

        });


    }

    private Function<TbTickets, TicketDTO> inverseConverter = (TbTickets tbTickets) ->{
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketId(tbTickets.getId());
        ticketDTO.setTicketPrice(tbTickets.getTicketPrice());
        ticketDTO.setDestination(tbTickets.getDestination());

        return ticketDTO;
    };
}
