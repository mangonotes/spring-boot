package com.sony.crm.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sony.crm.ui.dto.ResponseStatus;
import com.sony.crm.util.CustomOauthExceptionSerializer;
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOAuth2Exception extends OAuth2Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8979609891010923411L;
	private String response;
	private ResponseStatus status;
	public CustomOAuth2Exception(String msg) {
		super(msg);
	}
	public CustomOAuth2Exception(String response, ResponseStatus status) {
		super(response);
		this.response = response;
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	

}
