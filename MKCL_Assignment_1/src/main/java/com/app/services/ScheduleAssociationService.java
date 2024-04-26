package com.app.services;

import com.app.dao.ScheduleAssociationDao;

public class ScheduleAssociationService {

	public void saveData(Long eventId, Long paperId, Long scheduleId) {
		
		
		ScheduleAssociationDao dao= new ScheduleAssociationDao();
		dao.saveData(eventId,paperId,scheduleId);
	}

}
