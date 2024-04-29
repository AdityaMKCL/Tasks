package com.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public String getListOfPapers(Long eventId, Long scheduleId) {
		List<SchedulePaperAssociation> li= new ArrayList<>();
		String ans="";
		try {
			
			SchedulePaperAssociation schedule= new SchedulePaperAssociation();
			schedule.setFkExamEventID(eventId);
			schedule.setFkScheduleID(scheduleId);
			Map<String,Long> map= new HashMap<String,Long>();
			map.put("fkExamEventID", eventId);
			map.put("fkScheduleID", scheduleId);
			li=curd.findBy(SchedulePaperAssociation.class,map);
			for(SchedulePaperAssociation sec:li) {
				Long tem = sec.getFkPaperID();
				ans+=tem.toString()+",";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(ans.length()>0)return ans.substring(0, ans.length()-1);
		return ans;
	}

}
