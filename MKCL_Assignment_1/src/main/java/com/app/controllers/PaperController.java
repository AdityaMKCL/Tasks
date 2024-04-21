package com.app.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Paper;
import com.app.services.PaperService;

@RestController
@RequestMapping("/papers")
public class PaperController {
	
	public PaperService service= new PaperService();
	
	@GetMapping("/list")
	public String getPaperList() {
		String answer="";
		answer=service.getAllPapers();
		return answer;
	}
	
}
