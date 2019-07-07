package com.sony.crm.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.crm.dao.entity.TbCustMaster;
import com.sony.crm.dao.repository.CustomerRepository;
@Service
public class CustService  {
	private CustomerRepository customerRepository;
	@Autowired
	public CustService(CustomerRepository customerRepository)
	{
		this.customerRepository= customerRepository;
	}
	public void save(TbCustMaster tbCustMaster)
	{
		customerRepository.save(tbCustMaster);
	}

}
