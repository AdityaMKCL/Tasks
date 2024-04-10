package com.app.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.UserDao;
import com.app.entity.User;

@RestController
public class RegistrationController {
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
//	@RequestMapping(value={"/getstates"},method=RequestMethod.GET,headers="Accept=*/*") 
	@GetMapping("/getstates")
	public String getStates(){
		UserDao udao= new UserDao();
		ArrayList<String> arr= new ArrayList<String>();
		arr=udao.getStates();
		System.out.println(arr);
		return arr.toString();
	}
	
	@GetMapping("/getcities/{state}")
	public String getCities(@PathVariable String state) {
		UserDao udao=new UserDao();
		ArrayList<String> arr=new ArrayList<String>();
		arr=udao.getCities(state);
		return arr.toString();
	}
	
	@GetMapping("/login")
	public ModelAndView addUser(@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,
			@RequestParam("state") String state,
			@RequestParam("city") String city)
	{
		User u= new User(fname,lname,state,city);
		System.out.println(u);
		UserDao udao=new UserDao();
		
		if(udao.saveUser(u)) {
			System.out.println("user saved succesfully");
		}else {
			System.out.println("Some error occured");
		}
		return new ModelAndView("index");
	}
	
	@GetMapping("/delete/{roll}")
	public RedirectView deleteStudent(@PathVariable("roll") Integer roll) {
		UserDao sdao=new UserDao();
		sdao.deleteUser(roll);
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://localhost:8081/Registration_Ajax/");
		
		return redirectView;
	}
}
