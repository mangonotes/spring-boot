package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.ui.dto.CustomerDTO;
import org.sony.jpa.demo.ui.dto.TravellerDTO;

import java.util.List;

public interface ICustomerServices {
List<CustomerDTO> getAllCustomer();
CustomerDTO getCustomerByNamedQuery(int id);
CustomerDTO getCustomerByJplQuery(int id);
CustomerDTO getCustomerByJplWithoutProjections(int id);
CustomerDTO getCustomerByIdCriteria(int id);
CustomerDTO insert(CustomerDTO data);
CustomerDTO update(CustomerDTO data);
List<TravellerDTO> getallTravellers();

}
