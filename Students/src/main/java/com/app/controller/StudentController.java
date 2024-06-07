package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.StudentDao;
import com.app.entity.Student;
import com.app.utils.Validator;


@Controller
public class StudentController {
	
	Validator validate=new Validator();
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	@GetMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("index");
	}

	@GetMapping("/login")
	public ModelAndView getPage(@RequestParam("name") String name,@RequestParam("marks") Integer marks,
			@RequestParam("school") String school,@RequestParam("email") String email) {
		Student student=new Student(name,marks,school,email);
		StudentDao sdao=new StudentDao();
		ModelAndView m=new ModelAndView();
		String answer="";
		if(!validate.nameValidator(name)) answer+="Name ";
		if(!validate.emailValidator(email)) answer+="Email ";
		if(!validate.marksValidator(marks))answer+="marks ";
		if(!validate.schoolValidator(school))answer+="school ";
		System.out.println(answer);
		if( answer=="" && sdao.addStudent(student)) {
			m.setViewName("register");
			m.addObject(student);
		}else {m.setViewName("error");m.addObject("errormsg", answer);}
		return m;
	}
	
	@GetMapping("/delete/{roll}")
	public RedirectView deleteStudent(@PathVariable("roll") Integer roll) {
		StudentDao sdao=new StudentDao();
		RedirectView redirectView = new RedirectView();
		if(sdao.deleteStudent(roll))
	    redirectView.setUrl("http://localhost:8081/Students/");
		else 
			redirectView.setUrl("http://localhost:8081/Students/error.jsp");
		
		return redirectView;
	}
	@GetMapping("edit/{roll}")
	public ModelAndView editStudent(@PathVariable("roll") Integer roll) {
		StudentDao dao = new StudentDao();
		ModelAndView m=new ModelAndView();
		Student student=dao.getStudent(roll);
		m.setViewName("edit");
		m.addObject(student);
		return m;
	}
	
	@GetMapping("editstudent")
	public RedirectView editedStudent(@RequestParam("roll") Integer roll,
			@RequestParam("name") String name,@RequestParam("marks") Integer marks,
			@RequestParam("school") String school,@RequestParam("email") String email) {
		StudentDao sdao=new StudentDao();
		Student student=new Student(roll,name,marks,school,email);
		RedirectView redirectView = new RedirectView();
		if(sdao.updateStudent(student))
	    redirectView.setUrl("http://localhost:8081/Students/");
		else 
			redirectView.setUrl("http://localhost:8081/Students/error.jsp");
		
		return redirectView;
	}
}
