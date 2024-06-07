package com.app.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.entity.Student;

@Controller
public class StudentController {
	static ArrayList<Student> arr=new ArrayList<Student>();
	static int roll=0;
//	@RequestMapping(value = "/" ,method=RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		request.setAttribute("array", arr);
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/login")
	public RedirectView getPage(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("mobileNo") String mobileNo,
			@RequestParam("email") String email,@RequestParam("marks") Integer marks,HttpServletRequest request) {
		roll++;
		Student student=new Student(roll,firstName,lastName,mobileNo,marks,email);
		RedirectView m=new RedirectView("http://localhost:8081/collections_sms/");
		String answer="";
//		if(!validate.nameValidator(name)) answer+="Name ";
//		if(!validate.emailValidator(email)) answer+="Email ";
//		if(!validate.marksValidator(marks))answer+="marks ";
//		if(!validate.schoolValidator(school))answer+="school ";
//		System.out.println(answer);
//		if( answer=="" && sdao.addStudent(student)) {
//			m.setViewName("register");
//			m.addObject(student);
//		}else {m.setViewName("error");m.addObject("errormsg", answer);}
		arr.add(student);
		request.setAttribute("array", arr);
//		arr.forEach(System.out::println);
		return m;
	}
	
	@GetMapping("/delete/{roll}")
	public RedirectView deleteStudent(@PathVariable("roll") Integer roll) {
		
		RedirectView redirectView = new RedirectView();
		int idx=-1;
		for(int i=0;i<arr.size();i++)if(arr.get(i).getRollNum()==roll)idx=i;
		if(idx!=-1)arr.remove(idx);
	    redirectView.setUrl("http://localhost:8081/collections_sms/");
		return redirectView;
	}
	
	@GetMapping("/edit/{roll}")
	public ModelAndView editStudent(@PathVariable("roll") Integer roll) {
		
		ModelAndView m=new ModelAndView();
		Student student=new Student(0, null, null, null, 0, null);
		for(int i=0;i<arr.size();i++)if(arr.get(i).getRollNum()==roll)student=arr.get(i);
		m.setViewName("edit");
		m.addObject(student);
		return m;
	}
	
	@GetMapping("/editstudent")
	public RedirectView editedStudent(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("mobileNo") String mobileNo,
			@RequestParam("email") String email,@RequestParam("marks") Integer marks,HttpServletRequest request) {
		Student student=new Student(roll,firstName,lastName,mobileNo,marks,email);
		RedirectView redirectView = new RedirectView();
		for(int i=0;i<arr.size();i++)if(arr.get(i).getRollNum()==roll)arr.set(i, student);
		redirectView.setUrl("http://localhost:8081/collections_sms/");
		
		return redirectView;
	}
}
