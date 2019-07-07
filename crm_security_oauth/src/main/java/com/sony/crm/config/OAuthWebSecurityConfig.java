package com.sony.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration

public class OAuthWebSecurityConfig extends  WebSecurityConfigurerAdapter {
	
 @Autowired
 private BCryptPasswordEncoder passwordEncoder; 
 @Qualifier("jdbcUserDetailsService")
 @Autowired
 private UserDetailsService jdbcUserDetailsService;
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
   
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  
    	http.authorizeRequests()
        .antMatchers("/h2-console/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and().formLogin()
        .and().csrf().ignoringAntMatchers("/h2-console/**")
        .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin url otherwise h2-console not able to access
    
    	
    	
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.parentAuthenticationManager(authenticationManagerBean());
      auth.userDetailsService(jdbcUserDetailsService);

      auth.parentAuthenticationManager(null);
    }
}
