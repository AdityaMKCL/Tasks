package com.app.dao;

import com.app.models.SchedulePaperAssociation;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ScheduleAssociationDao {
	public ISql curd=DALHelper.getIsql();

	public void saveData(Long eventId, Long paperId, Long scheduleId) {
		
		try {
			SchedulePaperAssociation schedule= new SchedulePaperAssociation();
			schedule.setFkExamEventID(eventId);
			schedule.setFkScheduleID(scheduleId);
			schedule.setFkPaperID(paperId);
			curd.save(schedule);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
