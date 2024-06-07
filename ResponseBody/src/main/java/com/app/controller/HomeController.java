package com.app.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.User;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/submit")
	public void getData(@ModelAttribute User use) {
	    System.out.println("inside the controller");
	    System.out.println(use.toString());
	}
}
