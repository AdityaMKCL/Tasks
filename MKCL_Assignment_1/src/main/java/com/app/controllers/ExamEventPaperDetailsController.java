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

	@ResponseBody
	@GetMapping("/finalPaper")
	public String savepaper(@RequestParam("Paper") String paper, @RequestParam("examType") String examType,
			@RequestParam("NoOfAttempts") Integer noOfAttempts,
			@RequestParam("IdenticalOptions") String identicaloptions,
			@RequestParam("identicalItems") String identicalItems,
			@RequestParam("optionRandomization") String optionRandomization,
			@RequestParam("doublePalletNavigation") String doublePalletNavigation,
			@RequestParam("skipQuestion") String skipQuestion, @RequestParam("answerChange") String answerChange,
			@RequestParam("showNotepad") String showNotepad, HttpServletRequest request

	) {

		HttpSession session = request.getSession();
		ExamEvent e = (ExamEvent) session.getAttribute("examEvent");
		Long eventid=e.getExamEventID();
		 ExamEventPaperDetails edetail=new ExamEventPaperDetails();
		System.out.println("in the save papers controller ");
		return null;
	}
}
