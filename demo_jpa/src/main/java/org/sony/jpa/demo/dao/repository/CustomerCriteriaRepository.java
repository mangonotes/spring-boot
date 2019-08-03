package org.sony.jpa.demo.dao.repository;

import org.sony.jpa.demo.dao.enitty.TbCustMaster;

import java.util.Optional;

public interface CustomerCriteriaRepository {
	Optional<TbCustMaster> findByCustomerCriteria(int id);
	

}
