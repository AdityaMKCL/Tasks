package com.app.services;

import java.util.ArrayList;

import com.app.dao.ExamEventPaperDao;
import com.app.dao.ExamEventPaperDetailsDao;
import com.app.models.ExamEvent;
import com.app.models.ExamEventPaperDetails;

public class ExamEventPaperService {

	public boolean savePapers(String mySet, ExamEvent event) {
			boolean flag=true;
			ArrayList<Long> arr=new ArrayList<Long>();
			for(String tem:mySet.split(",")) {
				arr.add(Long.parseLong(tem.trim()));
			}
			long eventId=event.getExamEventID();
			ExamEventPaperDao edao=new ExamEventPaperDao();
			flag=edao.saveAllExamExamEventPapers(arr,eventId);
			return flag;
	}

	public String getEventPapers(Long id) {
		ExamEventPaperDao edao=new ExamEventPaperDao();
		ArrayList<Long> arr= new ArrayList<Long>();
		arr=edao.getEventPapers(id);
		return arr.toString();
	}

	public void savePaperDetails(ExamEventPaperDetails edetail) {
		getEventPaperByEventAndPaperId(edetail);
	}

	private ExamEventPaperDetails getEventPaperByEventAndPaperId(ExamEventPaperDetails edetail) {
		ExamEventPaperDetails e= new ExamEventPaperDetails();
		ExamEventPaperDetailsDao edao=new ExamEventPaperDetailsDao();
		e=edao.getExamEventDetail(edetail);
		return e;
	}

}
