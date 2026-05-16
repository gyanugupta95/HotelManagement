package com.example.HotelManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/home") 
	public String test() {
		return "Welcome to The India";
	}

}
