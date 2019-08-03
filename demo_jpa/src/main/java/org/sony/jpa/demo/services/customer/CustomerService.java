package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.dao.enitty.TbCustMaster;
import org.sony.jpa.demo.dao.repository.TravellerRepository;
import org.sony.jpa.demo.ui.dto.CustomerDTO;
import org.sony.jpa.demo.ui.dto.TicketDTO;
import org.sony.jpa.demo.ui.dto.TravellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.sony.jpa.demo.dao.repository.CustomerRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService implements ICustomerServices {
	private final CustomerRepository customerRepository;
	private final TravellerRepository travellerRepository;

	@Autowired
	public CustomerService(CustomerRepository repository, TravellerRepository travellerRepository) {
		this.customerRepository = repository;
		this.travellerRepository=travellerRepository;
	}

	@Override
	public CustomerDTO getCustomerByJplWithoutProjections(int  id) {
	return	this.customerRepository.findByIdBySelectedFieldsWithoutProjections(id).map(tbCustMaster -> {
			CustomerDTO customer = new CustomerDTO(tbCustMaster.getCreatedBy(), tbCustMaster.getId());
			return customer;
		}).get();
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		return this.customerRepository.findAll().stream().map(tbCustMaster -> {
			CustomerDTO customerDTO = new CustomerDTO(tbCustMaster.getFirstName(), tbCustMaster.getLastName(),
					tbCustMaster.getDoj(), tbCustMaster.getCreatedDt(), tbCustMaster.getUserName(), tbCustMaster.getId());
			return customerDTO;

		}).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	}

	@Override
	public CustomerDTO getCustomerByNamedQuery(int id) {
	return 	this.customerRepository.findAllCustmerByDescending(id).stream().findFirst().map(tbCustMaster ->{
			CustomerDTO customer = new CustomerDTO(tbCustMaster.getFirstName(), tbCustMaster.getUserName());
			return customer;
		}).get();
	}

	@Override
	public CustomerDTO getCustomerByJplQuery(int id) {
		return this.customerRepository.findByIdBySelectedFieldsWithProjections(id).stream().findFirst().map(tbCustMaster ->{
			CustomerDTO customer = new CustomerDTO(tbCustMaster.getCreatedBy(), tbCustMaster.getId());
			return customer;	
		}).get();
	}

	@Override
	public CustomerDTO getCustomerByIdCriteria(int id) {
		return this.customerRepository.findByCustomerCriteria(id).map(tbCustMaster -> {
			CustomerDTO customer = new CustomerDTO(tbCustMaster.getCreatedBy(), tbCustMaster.getId());
			return customer;
		}).get();
	}

	@Override
	public CustomerDTO insert(CustomerDTO data) {

		TbCustMaster daoEntity=	this.customerRepository.saveAndFlush(convert.apply(data));

	return inverseConverter.apply(	daoEntity);
	}

	@Override
	public CustomerDTO update(CustomerDTO data) {
		TbCustMaster daoEntity=  this.customerRepository.saveAndFlush(convert.apply(data));
		daoEntity.setModifiedBy("Admin");
		return inverseConverter.apply(daoEntity);
	}

	@Override
	public List<TravellerDTO> getallTravellers() {
		return travellerRepository.findAllTravellerWithJoin().stream().map(tbTraveller -> {
			TravellerDTO travellerDTO = new TravellerDTO();
		List<TicketDTO> ticketDTOList=	tbTraveller.getTbTicketsSet().stream().map(tbTickets -> {
				TicketDTO ticketDTO = new TicketDTO();
				ticketDTO.setDestination(tbTickets.getDestination());
				ticketDTO.setTicketPrice(tbTickets.getTicketPrice());
				ticketDTO.setTicketId(tbTickets.getId());
				return ticketDTO;
			}).collect(Collectors.toList());
		travellerDTO.setTickets(ticketDTOList);
			return travellerDTO;
		}).collect(Collectors.toList());

	}

	private Function<CustomerDTO, TbCustMaster> convert = (CustomerDTO customerDTO) ->{
		TbCustMaster tbCustMaster = new TbCustMaster();
		tbCustMaster.setCreatedBy("Admin01");
		tbCustMaster.setCreatedDt(new Date());
		tbCustMaster.setDoj(customerDTO.getDoj());
		if (customerDTO.getId() != -1)
		{
			tbCustMaster.setId(customerDTO.getId());
		}
		tbCustMaster.setFirstName(customerDTO.getFirstName());
		tbCustMaster.setLastName(customerDTO.getLastName());
		tbCustMaster.setUserEmail(customerDTO.getUserEmail());
		tbCustMaster.setUserName(customerDTO.getUserName());
		return tbCustMaster;
	};
	private Function<TbCustMaster,CustomerDTO > inverseConverter = (TbCustMaster tbCustMaster) ->{
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCreatedBy(tbCustMaster.getCreatedBy());
		customerDTO.setCreatedDate(tbCustMaster.getCreatedDt());
		customerDTO.setDoj(tbCustMaster.getDoj());
		customerDTO.setFirstName(tbCustMaster.getFirstName());
		customerDTO.setLastName(tbCustMaster.getLastName());
		customerDTO.setUserEmail(tbCustMaster.getUserEmail());
		customerDTO.setUserName(tbCustMaster.getUserName());
		customerDTO.setId(tbCustMaster.getId());
		return customerDTO;
	};
}
