package com.app.services;

import java.util.ArrayList;

import com.app.dao.ScheduleDao;
import com.app.models.ScheduleMaster;

public class ScheduleService {

	public boolean  saveSchedule(ScheduleMaster schedulemas) {
		boolean flag=true;
		ScheduleDao dao= new ScheduleDao();
		System.out.println("inside savschedule service");
		flag=dao.saveSchedule(schedulemas);
		return flag;
	}
	
	public ArrayList<ScheduleMaster> getall(){
		ArrayList<ScheduleMaster> arr= new ArrayList<>();
		ScheduleDao dao= new ScheduleDao();
		arr=dao.getAll();
		return arr;
		}

	public boolean deleteSchedule(Long id) {
		boolean flag=true;
		ScheduleDao dao= new ScheduleDao();
		flag=dao.deleteSchedule(id);
		return flag;
	}
	
	public ArrayList<ScheduleMaster> getallforEvent(Long id){
		ArrayList<ScheduleMaster> arr= new ArrayList<>();
		ScheduleDao dao= new ScheduleDao();
		arr=dao.getAllById(id);
		return arr;
	}

	public ScheduleMaster getSchedule(Long id) {
		
		ScheduleDao dao= new ScheduleDao();
		return dao.getSchedule(id);
	}

	public boolean updateSchedule(ScheduleMaster schedulemas) {
		boolean flag = true;
		ScheduleDao dao= new ScheduleDao();
		System.out.println("inside updatechedule service");
		flag=dao.updateSchedule(schedulemas);
		return flag;
		
		
	}
	
}
