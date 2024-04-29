package com.app.services;

import com.app.dao.ScheduleAssociationDao;

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

}
