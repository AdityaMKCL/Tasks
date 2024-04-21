package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.services.LanguageService;

@RestController
public class LanguageController {
	
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/langlist")
	public String languages() {
		 LanguageService service=new LanguageService();
		String answer="";
		answer=service.getAllLanguage();
		System.out.println(service.getAllLanguage());
//		System.out.println("controller");
		System.out.println(answer);
		return answer;
	}
	
	@GetMapping("/papers")
	public ModelAndView addpaper() {
		return new ModelAndView("addPaper");
	}
}
