package com.sony.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sony.example.demo.to.AddressTO;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) throws JsonProcessingException
	{
		AddressTO addressto = new AddressTO("Singapore", "City Hall", "22BC");
		model.addAttribute("data", addressto);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(addressto);
		model.addAttribute("data_json", json);
		return "home";
	}
	@RequestMapping("/load")
	public String load(Model model) throws JsonProcessingException
	{
		
		return "load";
	}
	
}
