package com.app.controllers;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.models.ExamEvent;
import com.app.models.ScheduleMaster;
import com.app.services.ScheduleService;
import com.app.utils.Validator;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@GetMapping("/redirect")
	public String send() {
		System.out.println("hello redirect ");
		return "schedule1";
	}
	@GetMapping("/redirect1")
	public String sendto() {
		System.out.println("hello redirect2 ");
		return "schedule2";
	}
	
	@GetMapping("/save")
	public String saveSchedule(@RequestParam("scheduleId") Long scheduleId,
								@RequestParam("scheduleType") String scheduleType,
								@RequestParam("maxNoOfPapers") Integer maxNoOfPapers,
								@RequestParam("startDate") String startDate,
								@RequestParam("endDate") String endDate,HttpServletRequest request) {
		
		try {
			
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		    Date startDatee = dateFormat.parse(startDate);
		    Date endDatee = dateFormat.parse(endDate);
		    HttpSession session=request.getSession();
		    ExamEvent e=(ExamEvent) session.getAttribute("examEvent");
		    ScheduleMaster schedulemas= new ScheduleMaster(startDatee,endDatee,e.getExamEventID(),scheduleType,maxNoOfPapers);
		    if(!Validator.validateSchedule(schedulemas)) {
		    	return "error";
		    }
		    	
		    ScheduleService service = new ScheduleService();
		    service.saveSchedule(schedulemas);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("inside the save of schedule controller");
		return "schedule1";
	}
	@GetMapping("/update")
	public String updateSchedule(@RequestParam("scheduleId") Long scheduleId,
			@RequestParam("scheduleType") String scheduleType,
			@RequestParam("maxNoOfPapers") Integer maxNoOfPapers,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,HttpServletRequest request) {
		
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date startDatee = dateFormat.parse(startDate);
			Date endDatee = dateFormat.parse(endDate);
			HttpSession session=request.getSession();
			ExamEvent e=(ExamEvent) session.getAttribute("examEvent");
			ScheduleMaster schedulemas= new ScheduleMaster(scheduleId,startDatee,endDatee,e.getExamEventID(),scheduleType,maxNoOfPapers);
			if(!Validator.validateSchedule(schedulemas)) {
		    	return "error";
		    }
			ScheduleService service = new ScheduleService();
			session.setAttribute("schedule", null);
			service.updateSchedule(schedulemas);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("inside the save of schedule controller");
		return "schedule1";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSchedule(@PathVariable Long id) {
		String answer="OK";
	    ScheduleService service = new ScheduleService();
	    boolean flag =service.deleteSchedule(id);
	    if(flag)return "schedule1";
	    else return "error";
	}
	
	@GetMapping("/get/{id}")
	public String getSchedule(@PathVariable Long id,HttpServletRequest request) {
		String ans="schedule1";
		ScheduleService service = new ScheduleService();
		ScheduleMaster master =service.getSchedule(id);
		if( master != null && master.getScheduleID() !=0) {
			
		HttpSession session = request.getSession();
		session.setAttribute("schedule", master);
		}else ans="error";
		
		return ans;
	}
	
	@ResponseBody
	@GetMapping(("/getlist/{id}"))
	public String getAllScheduleByEvent(@PathVariable Long id) {
		ArrayList<ScheduleMaster> arr= new ArrayList<>();
		ScheduleService service = new ScheduleService();
		String ans="";
		arr= service.getallforEvent(id);
		for(ScheduleMaster master:arr) {
			ans+=master.toString();
			ans+=",";
		}
		return ans.substring(0, ans.length()-1);
	}
	
	
	
}
