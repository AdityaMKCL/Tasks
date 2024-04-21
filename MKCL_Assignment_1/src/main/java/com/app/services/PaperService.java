package com.app.services;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.PaperDao;
import com.app.models.Paper;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class PaperService {

	private PaperDao dao=new PaperDao();

	public String getAllPapers(){
		ArrayList<Paper> arr=new ArrayList<Paper>();
		arr=dao.getAllPapers();
		ArrayList<String> ans=new ArrayList<String>();
		for(Paper p:arr) {
			ans.add(p.toString());
		}
		return ans.toString();
	}
	
}
