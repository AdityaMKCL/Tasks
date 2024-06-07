package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mltiple")
public class MultipleControl {
  
	@GetMapping("/home")
	public String helloWorld() {
		return "hello";
	}
	
}
