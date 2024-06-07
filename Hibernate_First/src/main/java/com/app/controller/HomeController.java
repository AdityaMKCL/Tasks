package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.CandidateDao;
import com.app.dao.ProgrammingLangDao;
import com.app.dao.SkillsDao;
import com.app.entity.Candidate;
import com.app.entity.Gender;
import com.app.entity.ProgrammingLang;
import com.app.entity.Skills;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView Home()
	{
		ModelAndView newModel=new ModelAndView();
		newModel.addObject(new Candidate());
		newModel.setViewName("index");
		return newModel;
	}
	
	@GetMapping("/login")
	public RedirectView loginCandidate(@RequestParam("candidateId") String id,
			@RequestParam("candidateName") String name,
			@RequestParam("userName") String uname,
			@RequestParam("password") String password,
			@RequestParam("description") String description,
			@RequestParam("skills") String skills,
			@RequestParam("gender") String gender,
			@RequestParam("standard") String standard,
			@RequestParam("languages") String languages
			) {
		
		System.out.println(id + " " +name+" "+uname+ " " +password +" " +gender );
		System.out.println(skills);
		System.out.println(languages);
		
		Candidate candi=new Candidate(name,uname,password,description,Gender.valueOf(gender),Integer.parseInt(standard));
		System.out.println(candi.toString());
		CandidateDao cdao = new CandidateDao();
		ProgrammingLangDao pdao= new ProgrammingLangDao();
		SkillsDao sdao= new SkillsDao();
		cdao.addCandidate(candi);
		Long cid=cdao.getCandidateId(candi);
		System.out.println(cid);
		for(String s:languages.split(",")) {
			pdao.addLanguage(new ProgrammingLang(s,candi),cid );
		}
		for(String s:skills.split(",")) {
			sdao.addSkill(new Skills(s,candi),cid );
		}
		return new RedirectView("http://localhost:8081/Hibernate_First/");
	}
}
