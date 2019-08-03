package org.sony.jpa.demo.services.customer;

import org.sony.jpa.demo.dao.enitty.CorporateIdentityKey;
import org.sony.jpa.demo.dao.enitty.TbCorporateCustomer;
import org.sony.jpa.demo.dao.repository.CorporateCustomerRepository;
import org.sony.jpa.demo.ui.dto.CorporateCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CorporateService implements ICorporateService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    public CorporateService(CorporateCustomerRepository corporateCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    @Override
    public List<CorporateCustomerDTO> getAllcorprateCustomer() {
       return  corporateCustomerRepository.findAll().stream().map(tbCorporateCustomer -> {
           CorporateCustomerDTO corporateCustomerDTO = new CorporateCustomerDTO();
           corporateCustomerDTO.setAddress(tbCorporateCustomer.getAddress());
           corporateCustomerDTO.setCorporateId(tbCorporateCustomer.getCorporateIdentityKey().getCorporateId());
           corporateCustomerDTO.setCorporateName(tbCorporateCustomer.getCorporateIdentityKey().getCorporateName());
           corporateCustomerDTO.setTotalValue(tbCorporateCustomer.getTotalValue());
           return corporateCustomerDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CorporateCustomerDTO> getAllcorporateCustomerById(int corporateId) {
       return  corporateCustomerRepository.findByCorporateIdentityKeyCorporateId(corporateId).stream().map(tbCorporateCustomer -> {
            CorporateCustomerDTO corporateCustomerDTO = new CorporateCustomerDTO();
            corporateCustomerDTO.setAddress(tbCorporateCustomer.getAddress());
            corporateCustomerDTO.setCorporateId(tbCorporateCustomer.getCorporateIdentityKey().getCorporateId());
            corporateCustomerDTO.setCorporateName(tbCorporateCustomer.getCorporateIdentityKey().getCorporateName());
            corporateCustomerDTO.setTotalValue(tbCorporateCustomer.getTotalValue());
            return corporateCustomerDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public CorporateCustomerDTO getCorporateCustomer(String coporateName, int corporateId) {
        Optional<CorporateCustomerDTO> corporateCustomerDTOOptional =corporateCustomerRepository.findById(new CorporateIdentityKey(corporateId, coporateName)).map(tbCorporateCustomer -> {
            CorporateCustomerDTO corporateCustomerDTO = new CorporateCustomerDTO();
            corporateCustomerDTO.setTotalValue(tbCorporateCustomer.getTotalValue());
            corporateCustomerDTO.setCorporateName(tbCorporateCustomer.getCorporateIdentityKey().getCorporateName());
            corporateCustomerDTO.setAddress(corporateCustomerDTO.getAddress());
            corporateCustomerDTO.setCorporateId(tbCorporateCustomer.getCorporateIdentityKey().getCorporateId());
            return  corporateCustomerDTO;
        });
         if (corporateCustomerDTOOptional.isPresent())
        {
            return corporateCustomerDTOOptional.get();
        }
            return new CorporateCustomerDTO();

    }
}
