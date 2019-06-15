package com.sony.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
@RequestMapping("/")
public String root ()
{
	return "testing";
	
}
}
