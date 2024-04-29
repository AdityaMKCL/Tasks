package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.services.ScheduleAssociationService;
import com.app.utils.Validator;

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
		if(!Validator.validateScheduleAssociation(eventId,scheduleId,paperId))return "error";
		service.saveData(eventId,paperId,scheduleId);
		
		return "scheduleassociation";
	}
	@ResponseBody
	@GetMapping("/getalreadyList")
	public String getAllList(@RequestParam("eventId") Long eventId,@RequestParam("scheduleId") Long scheduleId) {
		ScheduleAssociationService service = new ScheduleAssociationService();
		return service.getListOfPapers(eventId,scheduleId);
		
	}
	
}
