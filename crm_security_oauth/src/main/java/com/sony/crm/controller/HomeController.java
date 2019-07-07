package com.sony.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sony.crm.ui.dto.BaseRequest;
import com.sony.crm.ui.dto.BaseResponse;
import com.sony.crm.ui.dto.UserDTO;

@RestController
public class HomeController {
	@GetMapping("/api/home")
    public BaseResponse<?> home(@RequestParam String name) {
	return new BaseResponse<String>("welcome to home " + name);
    }
	@PostMapping("/api/postUser")
	public <T> BaseResponse<?> postUser(@RequestBody BaseRequest<UserDTO> request)
	{
		System.out.println("request" + request.getRequest().getName());
		return new BaseResponse<String>("welcome to home" );
	}
}
