package com.app.services;

import java.util.ArrayList;

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
			eve=icurd.findOne(ExamEvent.class, "name", event.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return eve;
	}

	public boolean updateEvent(ExamEvent e) {
		boolean flag=true;
		try {
			icurd.update(e);
			
		}catch(Exception eve) {
			eve.printStackTrace();
			flag=false;
		}
		return flag;
	}

	public ArrayList<ExamEvent> getAllEvents() {
		ArrayList<ExamEvent> arr= new ArrayList<ExamEvent>();
		try {
			arr=(ArrayList<ExamEvent>) icurd.findAll(ExamEvent.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public ExamEvent getExamEvent(Long id) {
		
		ExamEvent eve=new ExamEvent();
		try {
			eve=(ExamEvent) icurd.findBy(ExamEvent.class, "examEventID", id).get(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return eve;
	}
	
}
