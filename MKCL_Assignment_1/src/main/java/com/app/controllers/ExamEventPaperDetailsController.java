package com.app.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.app.models.ExamEvent;
import com.app.models.ExamEventPaperDetails;
import com.app.models.paperDto;
import com.app.services.ExamEventPaperService;

@Controller
@RequestMapping("/exameventpaper")
public class ExamEventPaperDetailsController {
	@ResponseBody
	@GetMapping("/savepapers")
	public String saveAllPapers(@RequestParam("papers") String mySet, HttpServletRequest request) {
		String ans = "";
		System.out.println();
		ExamEvent event = (ExamEvent) request.getSession().getAttribute("examEvent");
		ExamEventPaperService service = new ExamEventPaperService();
		service.savePapers(mySet, event);
		return ans;

	}

	@ResponseBody
	@GetMapping("/getpapers/{id}")
	public String getEventPapers(@PathVariable Long id) {
		String ans = "";
		ExamEventPaperService service = new ExamEventPaperService();
		ans = service.getEventPapers(id);
		System.out.println("ANS");
		return ans;

	}

	public boolean getit(String check) {
		check=check.trim();
		if(check.equals("Yes"))return true;
		return false;
	}
	
	@ResponseBody
	@GetMapping("/finalPaper")
	public RedirectView savepaper(@RequestParam("Paper") String paper, @RequestParam("examType") String examType,
			@RequestParam("NoOfAttempts") Integer noOfAttempts,
			@RequestParam("IdenticalOptions") String identicaloptions,
			@RequestParam("identicalItems") String identicalItems,
			@RequestParam("optionRandomization") String optionRandomization,
			@RequestParam("doublePalletNavigation") String doublePalletNavigation,
			@RequestParam("skipQuestion") String skipQuestion ,
			@RequestParam("answerChange") String answerChange,
			@RequestParam("showNotepad") String showNotepad, HttpServletRequest request

	) {

		HttpSession session = request.getSession();
		ExamEvent e = (ExamEvent) session.getAttribute("examEvent");
		Long eventid=e.getExamEventID();
//		System.out.println(identicaloptions);
//		System.out.println(identicalItems);
		 ExamEventPaperDetails edetail=new ExamEventPaperDetails(eventid, Long.parseLong(paper),noOfAttempts,getit(optionRandomization),
				 examType, getit(identicaloptions),getit(identicalItems), getit(skipQuestion),
					getit(answerChange),getit(showNotepad), getit(doublePalletNavigation));
		ExamEventPaperService service = new ExamEventPaperService();
		//System.out.println(edetail.toString());
		service.savePaperDetails(edetail);
		System.out.println("in the save papers controller ");
		return new RedirectView("http://localhost:8081/MKCL_Assignment_1/paperconfig/");
	}
}
