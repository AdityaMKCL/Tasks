package com.app.services;

import java.util.ArrayList;

import com.app.dao.ScheduleAssociationDao;
import com.app.models.DisplayFinalDto;

public class ScheduleAssociationService {

	public void saveData(Long eventId, Long paperId, Long scheduleId) {
		
		
		ScheduleAssociationDao dao= new ScheduleAssociationDao();
		dao.saveData(eventId,paperId,scheduleId);
	}

	public String getListOfPapers(Long eventId, Long scheduleId) {
		// TODO Auto-generated method stub
		ScheduleAssociationDao dao= new ScheduleAssociationDao();
		return dao.getListOfPapers(eventId,scheduleId);
		
	}
	
	public ArrayList<DisplayFinalDto> getEventPaperSchedule(){
		ArrayList<DisplayFinalDto> arr=new ArrayList<DisplayFinalDto>();
		ScheduleAssociationDao dao= new ScheduleAssociationDao();

		arr=dao.getEventPaperSchedule();
		return arr;
	}

}
