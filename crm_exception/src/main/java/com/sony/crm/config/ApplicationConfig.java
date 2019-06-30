package com.sony.crm.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
