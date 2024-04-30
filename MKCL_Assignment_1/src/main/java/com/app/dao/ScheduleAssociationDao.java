package com.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.models.DisplayFinalDto;
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

	public ArrayList<DisplayFinalDto> getEventPaperSchedule() {
		List<Object> result = null;
		ArrayList<DisplayFinalDto> arr= new ArrayList<>();
		try {
			String queryString = "SELECT e.name ,p.name,s.scheduleStart,s.scheduleEnd FROM ExamEvent e,ScheduleMaster s,Paper p,SchedulePaperAssociation"
					+ " sm WHERE " + 
					"e.examEventID=sm.fkExamEventID AND s.scheduleID=sm.fkScheduleID AND p.paperID=sm.fkPaperID";
			result = this.curd.executeQuery(queryString);
			for (Object objectItr : result) {
				DisplayFinalDto dto = new DisplayFinalDto();
				Object[] rows = (Object[]) objectItr;
				dto.setEvent((String)rows[0]);
				dto.setPaper((String)rows[1]);
				dto.setStartDate((Date)rows[2]);
				dto.setEndDate((Date)rows[3]);
				arr.add(dto);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
