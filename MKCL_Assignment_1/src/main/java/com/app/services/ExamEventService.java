package com.app.services;

import com.app.models.ExamEvent;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExamEventService {

	private ISql icurd = DALHelper.getIsql();
	
	public boolean saveExamDetail(ExamEvent eve) {
		boolean flag=true;
		try {
			icurd.save(eve);
			
		}catch(Exception e) {
			flag=false;
		}
		return flag;
	}
	
	public ExamEvent findExamEvent(ExamEvent event) {
		ExamEvent eve=new ExamEvent();
		try {
			eve=icurd.findOne(ExamEvent.class, "examEventCode", event.getExamEventCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return eve;
	}
	
}
