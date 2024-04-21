package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.models.NaturalLanguage;
import com.app.models.Paper;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class PaperDao {
public ISql curd=DALHelper.getIsql();
	
	public ArrayList<Paper> getAllPapers(){
		ArrayList<Paper> arr= new ArrayList<Paper>();
		try {
			List<Paper> li=new ArrayList<Paper>();
		   li=curd.findAll(Paper.class);
		   
		   arr=(ArrayList<Paper>) li;
			System.out.println(arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}
}
