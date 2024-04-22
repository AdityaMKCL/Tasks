package com.app.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.ExamEvent;
import com.app.services.ExamEventService;
import com.google.protobuf.TextFormat.ParseException;

@Controller
@RequestMapping("/examevent")
public class ExamEventController {

	
	@GetMapping("/save")
	public ModelAndView saveExamEvent(@RequestParam("name") String name,
			@RequestParam("examEventCode") String examEventCode,
			@RequestParam("defaultLanguageID") String defaultLanguageID,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate ,HttpServletRequest request) {
		ModelAndView md=new ModelAndView();
		 ExamEventService service=new ExamEventService();
		 System.out.println(name + " "+ examEventCode + " " +defaultLanguageID +" " + startDate);
		 try {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			    Date startDatee = dateFormat.parse(startDate);
			    Date endDatee = dateFormat.parse(endDate);
			    
			    ExamEvent examEvent = new ExamEvent(examEventCode,name, startDatee, endDatee, defaultLanguageID);
			    service.saveExamDetail(examEvent);
			    md.setViewName("index");
			    request.setAttribute("msg", "Data is saved succesfully");
			   HttpSession session = request.getSession();
			   ExamEvent e=service.findExamEvent(examEvent);
			   session.setAttribute("examEvent", e);
			   System.out.println(e);
			} catch (java.text.ParseException e) {
				request.setAttribute("msg", "Some error occured ");
			    e.printStackTrace(); 
			    md.setViewName("index");
			} catch (Exception e) {
				request.setAttribute("msg", "Some error occured ");
			    e.printStackTrace(); 
			    md.setViewName("index");
			}
		 
		 return md;
	}
	
}
