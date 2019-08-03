package org.sony.jpa.demo.controller;

import org.sony.jpa.demo.services.customer.ICustomerServices;
import org.sony.jpa.demo.ui.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
private 	ICustomerServices customerServices;
@Autowired
public  CustomerController( ICustomerServices customerServices) {
	this.customerServices= customerServices;
	
}	
@GetMapping("/getListing")
public ResponseEntity<List<CustomerDTO>> getListing()
{
	return new ResponseEntity<List<CustomerDTO>>(customerServices.getAllCustomer(), HttpStatus.OK);
}
@GetMapping("getListBynamedQuery")
public ResponseEntity<CustomerDTO> getListBynamedQuery(@RequestParam("id") int id)
{
	return new ResponseEntity<CustomerDTO>(customerServices.getCustomerByNamedQuery(id), HttpStatus.OK);
}
@GetMapping("getCustomerByJplQuery")
public ResponseEntity<CustomerDTO> getCustomerByJplQuery(@RequestParam("id") int id)
{
	return new ResponseEntity<CustomerDTO>(customerServices.getCustomerByJplQuery(id), HttpStatus.ACCEPTED);
}
@GetMapping("getCustomerByJplWithoutProjections")
public ResponseEntity<CustomerDTO> getCustomerWithoutProjections(@RequestParam("id") int id)
{

	return new ResponseEntity<CustomerDTO>(customerServices.getCustomerByJplWithoutProjections(id), HttpStatus.ACCEPTED);
}
@GetMapping("getCustomerByCriteria")
public ResponseEntity<CustomerDTO> getCustomerByCriteria(@RequestParam("id") int id)
{
	return new ResponseEntity<CustomerDTO>(customerServices.getCustomerByIdCriteria(id), HttpStatus.ACCEPTED);
}
@PostMapping("createCustomer")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO data)
{
	return new ResponseEntity<CustomerDTO>(customerServices.insert(data), HttpStatus.ACCEPTED);
}
@PutMapping("updateCustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO data)
{
	return new ResponseEntity<CustomerDTO>(customerServices.update(data), HttpStatus.ACCEPTED);
}
}
