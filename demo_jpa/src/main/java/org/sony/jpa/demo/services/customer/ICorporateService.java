package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.ui.dto.CorporateCustomerDTO;

import java.util.List;

public interface ICorporateService {
List<CorporateCustomerDTO> getAllcorprateCustomer();
CorporateCustomerDTO getCorporateCustomer(String coporateName, int corporateId);
List<CorporateCustomerDTO> getAllcorporateCustomerById(int corporateId);

}
