package com.sony.crm.dao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sony.crm.dao.entity.TbUserMaster;

public interface UserRespository extends CrudRepository<TbUserMaster, Integer>{
	Optional<TbUserMaster> findOneByUserName(String userName);


}
