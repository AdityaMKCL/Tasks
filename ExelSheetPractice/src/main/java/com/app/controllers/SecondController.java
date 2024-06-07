package com.app.controllers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("environment")
public class SecondController {
	
	Properties p = new Properties() ;
			

	
			@Value("${global.recordsPerPage}")
			Integer globalRecords;
			@Value("${QuestionPaperPath}")
			String QuestionPaperPath;
			@Value("${CandidateStatisticsReportPath}")
			String CandidateStatisticsReportPath;
			@Value("${ImagesPath}")
			String ImagesPath;
			@Value("${zipImagesPath}")
			String zipImagesPath;
			@Value("${UserDefaultImagePath}")
			String UserDefaultImagePath;
			@Value("${global.dateFormat}")
			String globalDateFormat;
			@Value("${global.dateFormatWithoutTime}")
			String globalDateFormatWithoutTime;
			@Value("${examClientVersion}")
			String examClientVersion;
			@Value("${wkhtmltopdfPath}")
			String wkhtmltopdfPath;
			@Value("${isCopyRightEnabled}")
			Boolean isCopyRightEnabled;
			@Value("${MaxCandidatesPerProctor}")
			Integer MaxCandidatesPerProctor;
			@Value("${isLoggingEnabled}")
			Boolean isLoggingEnabled;
			@Value("${isReportItemEnabled}")
			Boolean isReportItemEnabled;
	
	@GetMapping("/listing")
	public String page(HttpServletRequest model) {
		System.out.println(globalRecords);
		model.setAttribute("globalRecords", globalRecords);
		model.setAttribute("QuestionPaperPath",QuestionPaperPath);
		model.setAttribute("CandidateStatisticsReportPath",CandidateStatisticsReportPath);
		model.setAttribute("ImagesPath",ImagesPath);
		model.setAttribute("zipImagesPath",zipImagesPath);
		model.setAttribute("UserDefaultImagePath",UserDefaultImagePath);
		model.setAttribute("globalDateFormat",globalDateFormat);
		model.setAttribute("globalDateFormatWithoutTime",globalDateFormatWithoutTime);
		model.setAttribute("examClientVersion",examClientVersion);
		model.setAttribute("wkhtmltopdfPath",wkhtmltopdfPath);
		model.setAttribute("isCopyRightEnabled",isCopyRightEnabled);
		model.setAttribute("MaxCandidatesPerProctor",MaxCandidatesPerProctor);
		model.setAttribute("isLoggingEnabled",isLoggingEnabled);
		model.setAttribute("isReportItemEnabled",isReportItemEnabled);
		return "eighth";
	}
}
