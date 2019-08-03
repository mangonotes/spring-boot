package org.sony.jpa.demo.dao.repository;

import org.sony.jpa.demo.dao.enitty.CorporateIdentityKey;
import org.sony.jpa.demo.dao.enitty.TbCorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorporateCustomerRepository extends JpaRepository<TbCorporateCustomer, CorporateIdentityKey> {

List<TbCorporateCustomer> findByCorporateIdentityKeyCorporateId(int id);
}
