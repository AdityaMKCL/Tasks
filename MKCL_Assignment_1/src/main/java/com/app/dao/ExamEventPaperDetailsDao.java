package com.app.dao;

import java.util.List;


import com.app.models.ExamEventPaperDetails;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExamEventPaperDetailsDao {

	public ISql curd=DALHelper.getIsql();
	
		public ExamEventPaperDetails getExamEventDetail(ExamEventPaperDetails exam) {
			
			ExamEventPaperDetails event= new ExamEventPaperDetails();
			try {
				String hql = "SELECT  e FROM " + ExamEventPaperDetails.class.getName() + " e WHERE e.examEventID =" + exam.getExamEventID() +" and e.fkPaperID="+exam.getFkPaperID();
				 event = (ExamEventPaperDetails) curd.executeQuery(hql).get(0);
				 exam.setExamEventPaperID(event.getExamEventPaperID());
				 System.out.println("inside exameventdetaildao");
				 curd.update(exam);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return event;
		}
	
}
