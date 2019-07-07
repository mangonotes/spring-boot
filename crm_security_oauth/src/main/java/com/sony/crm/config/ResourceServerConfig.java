package com.sony.crm.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sony.crm.security.service.CustomOAuth2AccessDeniedHandler;
import com.sony.crm.security.service.CustomOauthEntryPoint;
import com.sony.crm.ui.dto.BaseResponse;
import com.sony.crm.ui.dto.ResponseStatus;
@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(true);
        resources.authenticationEntryPoint(new CustomOauthEntryPoint(jacksonObjectMapper)).accessDeniedHandler(new CustomOAuth2AccessDeniedHandler());
        //resources.accessDeniedHandler(new CustomOAuth2AccessDeniedHandler());
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                
                .and().headers().frameOptions().disable();
               
             
        http.exceptionHandling().authenticationEntryPoint((request, response, e) ->{
    		response.setContentType("application/json;charset=UTF-8");
    		BaseResponse<String> resp = new BaseResponse<String> ("Access Denied", new ResponseStatus("Access Denied", 503));
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            try {
				response.getWriter().write(jacksonObjectMapper.writeValueAsString(resp));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    	
    }
}
