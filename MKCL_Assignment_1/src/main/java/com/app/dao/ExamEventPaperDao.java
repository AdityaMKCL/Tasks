package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.models.ExamEventPaperDetails;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExamEventPaperDao {

	public ISql curd=DALHelper.getIsql();
	public boolean saveAllExamExamEventPapers(ArrayList<Long> arr, long eventId) {
	boolean flag=true;
	try {
		ArrayList<ExamEventPaperDetails> array= new ArrayList<ExamEventPaperDetails>();
		for(Long i : arr) {
			ExamEventPaperDetails edail=new ExamEventPaperDetails();
			edail.setExamEventID(eventId);
			edail.setFkPaperID(i);
			curd.save(edail);
		}
		//curd.saveCollection(array);
	}catch(Exception e) {
		flag=false;
		e.printStackTrace();
	}
		return flag;
	}
	public ArrayList<Long> getEventPapers(Long id) {
		ArrayList<Long> arr= new ArrayList<Long>();
		try {
			List<ExamEventPaperDetails> li=new ArrayList<ExamEventPaperDetails>();
			li=curd.findBy(ExamEventPaperDetails.class, "examEventID", id);
			for(ExamEventPaperDetails tem:li) {
				arr.add(tem.getFkPaperID());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
