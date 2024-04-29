package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.services.ScheduleAssociationService;

@Controller
@RequestMapping("/scheduleassoci")
public class ScheduleAssociationController {

	@GetMapping("/home")
	public String homePage() {
		return "scheduleassociation";
	}
	
	@GetMapping("/save")
	public String saveThePaper(@RequestParam("examEvent") Long eventId,
								@RequestParam("scheduleId") Long scheduleId,
								@RequestParam("paperId") Long paperId) {
		boolean flag=false;
		
		ScheduleAssociationService service = new ScheduleAssociationService();
		
		service.saveData(eventId,paperId,scheduleId);
		
		return "index";
	}
	@ResponseBody
	@GetMapping("/getalreadyList")
	public String getAllList(@RequestParam("eventId") Long eventId,@RequestParam("scheduleId") Long scheduleId) {
		ScheduleAssociationService service = new ScheduleAssociationService();
		return service.getListOfPapers(eventId,scheduleId);
		
	}
	
}
