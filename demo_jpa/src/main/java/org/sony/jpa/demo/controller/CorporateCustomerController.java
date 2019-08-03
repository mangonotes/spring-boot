package org.sony.jpa.demo.controller;

import org.sony.jpa.demo.services.customer.ICorporateService;
import org.sony.jpa.demo.ui.dto.CorporateCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CorporateCustomerController {
    private final ICorporateService corporateService;
    @Autowired
    public CorporateCustomerController(ICorporateService corporateService) {
        this.corporateService = corporateService;
    }

    @GetMapping("/getCorporateCustomer")
    public ResponseEntity<List<CorporateCustomerDTO>> getCorporateCustomers()
    {
        return new ResponseEntity<List<CorporateCustomerDTO>>(corporateService.getAllcorprateCustomer(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/findCorporateCustomer")
    public ResponseEntity<CorporateCustomerDTO> findCorporateCustomer(@RequestParam("corporateName")String corporateName, @RequestParam("corporateId")int corporateId ){
        return new ResponseEntity<CorporateCustomerDTO>(corporateService.getCorporateCustomer(corporateName, corporateId),HttpStatus.ACCEPTED);
    }
    @GetMapping("/findCorporateById")
    public ResponseEntity<List<CorporateCustomerDTO>> findCorporateCustomerById(@RequestParam("corporateId") int id)
    {
        return new ResponseEntity<List<CorporateCustomerDTO>> (corporateService.getAllcorporateCustomerById(id),HttpStatus.ACCEPTED);
    }
}
