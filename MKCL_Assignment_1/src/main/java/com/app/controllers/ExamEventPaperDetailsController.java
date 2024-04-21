package com.app.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.paperDto;

@Controller
@RequestMapping("/exameventpaper")
public class ExamEventPaperDetailsController {
  
	@GetMapping("/savepapers")
	public String saveAllPapers(@RequestParam("papers") String mySet) {
		String ans ="Success";
		System.err.println("/n/n/n/nHiiiiiiiiiiiiii/n/n/n/n");
		System.out.println(mySet);
		return ans;
		
	}
}
