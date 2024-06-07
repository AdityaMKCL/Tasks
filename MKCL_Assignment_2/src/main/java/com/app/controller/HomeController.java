package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.models.tempDto;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Homepage() {
		return "index";
	}
	
	
	@PostMapping("see") 
	public String Home(@RequestBody tempDto dto) {
		System.out.println(dto.toString());
		return "index";
	}
	
}
