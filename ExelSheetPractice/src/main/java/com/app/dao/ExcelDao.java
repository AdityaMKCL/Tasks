package com.app.dao;

import java.util.List;

import com.app.models.User;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExcelDao {

	public ISql curd=DALHelper.getIsql();
	public String addUsers(List<User> list) {
		try {
		curd.saveCollection(list);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
