package com.sony.crm.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/api/home")
    public Map home() {
		Map<String, String> resp= new HashMap<String, String>();
		resp.put("response", "This is testing api");
        return Collections.unmodifiableMap(resp);
    }
}
