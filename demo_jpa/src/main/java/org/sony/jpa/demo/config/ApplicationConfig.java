package org.sony.jpa.demo.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sony.jpa.demo.dao.enitty.*;
import org.sony.jpa.demo.dao.repository.CorporateCustomerRepository;
import org.sony.jpa.demo.dao.repository.CustomerRepository;
import org.sony.jpa.demo.dao.repository.TicketRepository;
import org.sony.jpa.demo.dao.repository.TravellerRepository;
import org.sony.jpa.demo.services.customer.ITicketService;
import org.sony.jpa.demo.ui.dto.TicketDTO;
import org.sony.jpa.demo.ui.dto.TravellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
	Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
	@Autowired
	CustomerRepository repository;
	@Autowired
	TravellerRepository travellerRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	ITicketService ticketService;
	@Autowired
	CorporateCustomerRepository corporateCustomerRepository;
	@PostConstruct 
	void insertData()
	{
		TbCustMaster tbCustMaster = new TbCustMaster();
		tbCustMaster.setUserName("Sonyjohn");
		tbCustMaster.setUserEmail("sonyjohn@hello.com");
		tbCustMaster.setCreatedDt(new Date());
		tbCustMaster.setDoj(new Date());
		tbCustMaster.setId(1);
		tbCustMaster.setFirstName("Sony");
		tbCustMaster.setLastName("john");
		tbCustMaster.setCreatedBy("Admin");
		repository.save(tbCustMaster);
		logger.info("saved data");
		logger.info("custom query repos find by cutomer id {}", repository.findByIdBySelectedFieldsWithProjections(1).stream().findFirst().get().getCreatedBy());
		logger.info("custom custom repos find by cutomer id {}", repository.findByCustomerCriteria(1).get().getCreatedBy());
		logger.info("named query findAllCustmerByDescending{}", repository.findAllCustmerByDescending(1).stream().findFirst().get().getFirstName() );
		TbTraveller tbTraveller = new TbTraveller();
		tbTraveller.setName("Testing");
		tbTraveller.setNationality("CHN");
		travellerRepository.save(tbTraveller);
		TbTickets tbTickets = new TbTickets();
		tbTickets.setDestination("Vietnam");
		tbTickets.setTicketPrice(120.00);
		tbTickets.setTbTraveller(tbTraveller);
		ticketRepository.save(tbTickets);
		Set<TbTickets> tbTicketsSet = travellerRepository.findAllTravellerWithJoin().stream().findFirst().get().getTbTicketsSet();
		logger.info("many to one mapping{}" , tbTicketsSet.size());
		List<TicketDTO> ticketDTOList = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setDestination("HKD");
		ticketDTO.setTicketPrice(1200.96);
		ticketDTOList.add(ticketDTO);
		TravellerDTO travellerDTO = new TravellerDTO();
		travellerDTO.setNationality("SGP");
		travellerDTO.setName("Testing");
		travellerDTO.setTickets(ticketDTOList);
		ticketService.insertTraveller(travellerDTO);
		TbCorporateCustomer tbCorporateCustomer = new TbCorporateCustomer();
		tbCorporateCustomer.setAddress("Testing address");
		tbCorporateCustomer.setCorporateIdentityKey(new CorporateIdentityKey(1,"test" ));
		corporateCustomerRepository.save(tbCorporateCustomer);



	}
}