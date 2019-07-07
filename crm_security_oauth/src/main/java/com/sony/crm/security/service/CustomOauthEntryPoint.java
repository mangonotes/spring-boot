package com.sony.crm.security.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sony.crm.ui.dto.BaseResponse;
import com.sony.crm.ui.dto.ResponseStatus;

public class CustomOauthEntryPoint implements AuthenticationEntryPoint{
	private ObjectMapper jacksonObjectMapper;
	public CustomOauthEntryPoint( ObjectMapper jacksonObjectMapper)
	{
		this.jacksonObjectMapper= jacksonObjectMapper;
	}
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		ResponseStatus status = new ResponseStatus(authException.getMessage(),502);
		BaseResponse<String> resp = new BaseResponse<String> ("Invalid Token", status);
		response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            jacksonObjectMapper.writeValue(response.getOutputStream(), resp);
        } catch (Exception e) {
            throw new ServletException();
        }
	}

}
