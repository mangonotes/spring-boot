package com.sony.crm.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sony.crm.dao.entity.TbCustMaster;

public interface CustomerRepository  extends CrudRepository<TbCustMaster, Integer>{
	List<TbCustMaster> findByUserEmail(String email);

}
