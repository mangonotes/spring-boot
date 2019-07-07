package com.sony.crm.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sony.crm.dao.entity.TbCustMaster;
import com.sony.crm.dao.entity.TbUserMaster;
import com.sony.crm.dao.repository.UserRespository;
import com.sony.crm.dao.service.CustService;
import com.sony.crm.filter.XssFilter;

@Configuration
public class ApplicationConfig {
	@Bean
	public FilterRegistrationBean<XssFilter> xssFilterBean(){
	    FilterRegistrationBean<XssFilter> xssFilter 
	      = new FilterRegistrationBean<>();
	    xssFilter.setFilter(new XssFilter());
	    xssFilter.addUrlPatterns("/api/*");
	    return xssFilter;    
	}
	@Autowired CustService custService;
	@Autowired UserRespository userRespository;
	   
	@PostConstruct 
	public void insertDb()
	{
		TbCustMaster tbCustMaster = new TbCustMaster();
		tbCustMaster.setUserName("Sonyjohn");
		tbCustMaster.setUserEmail("sonyjohn@borngroup.com");
		tbCustMaster.setCreatedDt(new Date());
		tbCustMaster.setDoj(new Date());
		tbCustMaster.setId(1);
		tbCustMaster.setFirstName("Sony");
		tbCustMaster.setLastName("john");
		tbCustMaster.setCreatedBy("Admin");
		
		custService.save(tbCustMaster);
		TbCustMaster tbCustMaster1 = new TbCustMaster();
		tbCustMaster.setUserName("Sonyjohn1");
		tbCustMaster.setUserEmail("sonyjohn1@borngroup.com");
		tbCustMaster.setCreatedDt(new Date());
		tbCustMaster.setDoj(new Date());
		tbCustMaster.setId(2);
		tbCustMaster.setFirstName("Sony1");
		tbCustMaster.setLastName("john1");
		tbCustMaster.setCreatedBy("Admin1");
		
		custService.save(tbCustMaster1);
		TbUserMaster user = new TbUserMaster();
		user.setEnabled(true);
		user.setPassword("$2a$10$s7rR9qxaUnOJaE3J6ZSICupQxm.xTJhvScmXV.ylsI3AIY5OMXp.q");
		user.setId(2);
		user.setUserName("user");
		
		userRespository.save(user);
	}
}
