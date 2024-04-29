package com.app.utils;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.ExamEvent;
import com.app.models.Paper;
import com.app.models.ScheduleMaster;

public class Validator {

	public static String validateExamEvent(ExamEvent e) {
		String ans = null;
		if (e.getDefaultLanguageID() == null || e.getDefaultLanguageID() == "")
			ans = "invalidated";
		if (e.getName() == null || e.getName() == "")
			ans = "invalidated";
		java.util.Date date = new java.util.Date();
		if (e.getExamEventCode() == null || e.getExamEventCode() == "")
			ans = "invalidated";
		if (e.getStartDate().before(date))
			ans = "invalidated";
		if (e.getStartDate().after(e.getEndDate()))
			ans = "invaldated";
		return ans;
	}

	public static boolean validatePaper(String paper, String examType, Integer noOfAttempts, String identicaloptions,
			String identicalItems, String optionRandomization, String doublePalletNavigation, String skipQuestion,
			String answerChange, String showNotepad) {

		boolean flag= true;
		
		if (paper == null || paper == "")flag=false;
		if(examType == null || examType == "")flag=false;
		if(noOfAttempts == null || noOfAttempts<0)flag=false;
		if(identicaloptions == null || identicaloptions == "")flag=false;
		if(identicalItems == null || identicalItems == "")flag=false;
		if(optionRandomization == null || optionRandomization == "")flag=false;
		if(doublePalletNavigation == null || doublePalletNavigation == "")flag=false;
		if(skipQuestion == null || skipQuestion == "")flag=false;
		if(answerChange == null || answerChange == "")flag=false;
		if(showNotepad == null || showNotepad == "")flag=false;
		
		return flag;
	}

	public static boolean validateSchedule(ScheduleMaster e) {
		boolean flag= true;
		if (e.getScheduleType() == null || e.getScheduleType()  == "")flag=false;
		if(e.getMaxNumberOfPapers()<0)flag=false;
		java.util.Date date = new java.util.Date();
		if (e.getScheduleStart().before(date))flag=false;
		if (e.getScheduleStart().after(e.getScheduleEnd()))flag=false;
		return flag;
	}

	public static boolean validateScheduleAssociation(Long eventId, Long scheduleId, Long paperId) {
		boolean flag=true;
		if(eventId==null || eventId<0)flag=false;
		if(scheduleId==null || scheduleId<0)flag=false;
		if(paperId==null || paperId<0)flag=false;
		return flag;
	}
}
