package com.app.utils;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.ExamEvent;
import com.app.models.Paper;

public class Validator {

	public static String validateExamEvent(ExamEvent e) {
		String ans = null;
		LocalDateTime now = LocalDateTime.now();
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
		
		
		return flag;
	}
}
