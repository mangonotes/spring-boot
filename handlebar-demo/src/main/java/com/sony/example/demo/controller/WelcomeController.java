package com.sony.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WelcomeController {
@RequestMapping("/")
public String root ()
{
	return "testing";
	
}
@RequestMapping("/product/catalog") 
public JsonNode getproductus() throws IOException

{ ObjectMapper mapper = new ObjectMapper();
	String jsonString = "{\"data\": {\"inventory_count\": 4995,\"variant_count\": 54,\"inventory_value\": 702350.03,\"highest_variant_price\": 555,\"average_variant_price\": 74.40055556,\"lowest_variant_price\": 7,\"oldest_variant_date\": \"2018-08-15\",\"newest_variant_date\": \"2018-09-07\",\"primary_category_id\": 23,\"primary_category_name\": \"Shop All\" },\"meta\": {}}";
	JsonNode actualObj = mapper.readTree(jsonString);
	return actualObj;
}

}
