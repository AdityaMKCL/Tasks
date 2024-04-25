package com.app.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.models.ExamEvent;
import com.app.services.ExamEventService;
import com.app.services.ScheduleService;
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
			    md.setViewName("error");
			} catch (Exception e) {
				request.setAttribute("msg", "Some error occured ");
			    e.printStackTrace(); 
			    md.setViewName("error");
			}
		 
		 return md;
	}
	
	@GetMapping("/config")
	public RedirectView configSchedule(HttpServletRequest request) {
		ExamEventService service=new ExamEventService();
		HttpSession session = request.getSession();
		ExamEvent e=(ExamEvent) session.getAttribute("examEvent");
		e.setIsActiveEvent(true);
		if(service.updateEvent(e))return new RedirectView("http://localhost:8081/MKCL_Assignment_1/manageevent/");
		return new RedirectView("http://localhost:8081/MKCL_Assignment_1/error");
	}
	
	@GetMapping("/getall")
	public ArrayList<ExamEvent> getAllEvents(){
		ArrayList<ExamEvent> arr= new ArrayList<ExamEvent>();
		ExamEventService service=new ExamEventService();
		arr=service.getAllEvents();
		//if(arr == null) some validations 
		return arr;
	}
	@ResponseBody
	@GetMapping("/getone/{id}")
	public String getAllEvent(@PathVariable Long id,HttpServletRequest request){
		System.out.println("hello from controller");
		ExamEventService service=new ExamEventService();
		ExamEvent e=service.getExamEvent(id);
		System.out.println(e.toString());
		HttpSession session = request.getSession();
		   session.setAttribute("examEvent", e);
		if(e==null)return "no";
		else return "yes";
	}
	
	
}
