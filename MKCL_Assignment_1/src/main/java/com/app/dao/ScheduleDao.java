package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.models.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ScheduleDao {
	public ISql curd=DALHelper.getIsql();

	public boolean saveSchedule(ScheduleMaster schedulemas) {
		boolean flag=false;
		try {
			curd.save(schedulemas);
			flag=true;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<ScheduleMaster> getAll() {
		List<ScheduleMaster> li= new ArrayList<ScheduleMaster>();
		try {
			li=curd.findAll(ScheduleMaster.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<ScheduleMaster>)li;
	}

	public boolean deleteSchedule(Long id) {
		boolean flag=true;
		try {
			curd.deleteBy(ScheduleMaster.class, "scheduleID" ,id);
		}catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<ScheduleMaster> getAllById(Long id) {
		List<ScheduleMaster> li= new ArrayList<>();
		try {
			li=curd.findBy(ScheduleMaster.class, "fkExamEventID", id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return (ArrayList<ScheduleMaster>) li;
	}

	public ScheduleMaster getSchedule(Long id) {
		ScheduleMaster sch= new ScheduleMaster();
		try {
			sch=curd.findBy(ScheduleMaster.class, "scheduleID",id).get(0);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return sch;
	}

	public boolean updateSchedule(ScheduleMaster schedulemas) {
		boolean flag=false;
		try {
			curd.update(schedulemas);
			flag=true;
		} catch (DALException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
