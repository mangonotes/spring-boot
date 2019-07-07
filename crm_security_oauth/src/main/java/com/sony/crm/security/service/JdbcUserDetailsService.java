package com.sony.crm.security.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sony.crm.controller.handler.ErrorHandler;
import com.sony.crm.dao.entity.TbUserMaster;
import com.sony.crm.dao.repository.UserRespository;

@Service("jdbcUserDetailsService")

public class JdbcUserDetailsService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(JdbcUserDetailsService.class);
	
	@Autowired
	private UserRespository userRespository;
	    public UserDetails loadUserByUsername(String username) {
	    	 logger.info("jdbcUserDetials{}", username);
	        Optional<TbUserMaster> user = userRespository.findOneByUserName(username);
	         logger.info("jdbcUserDetials1...{}" , user.isPresent());
	        user.orElseThrow(() -> new UsernameNotFoundException(username));
	        logger.info("jdbcUserDetials{}" , user);
	       
	        SecurityUser securityUser  = new SecurityUser(user.get());
	        return securityUser;
}
}
