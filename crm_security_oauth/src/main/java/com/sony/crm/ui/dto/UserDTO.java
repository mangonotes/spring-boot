package com.sony.crm.ui.dto;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.sony.crm.util.StringHtmlDeSerializer;

public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 543985041778304295L;
	@JsonDeserialize (using = StringHtmlDeSerializer.class)
	private String name;
	@JsonDeserialize(using = StringHtmlDeSerializer.class)
	private String lastName;
	public UserDTO()
	{
		
	}
	public UserDTO(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public static void main (String args []) throws JsonProcessingException, JsonMappingException, IOException
	{
		String json = "{\"name\":\"sony\" , \"lastName\" : \"<html>john</html>\"}";
		ObjectMapper mapper = new ObjectMapper();
		UserDTO user=	mapper.readValue(json, UserDTO.class);
		System.out.println("json" + user.getLastName());
		
		
		
	}
	

}
