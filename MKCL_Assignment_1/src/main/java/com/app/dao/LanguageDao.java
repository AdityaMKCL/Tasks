package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.models.NaturalLanguage;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;


public class LanguageDao {
	
	public ISql curd=DALHelper.getIsql();
	
	public ArrayList<String> getAllLanguages(){
		ArrayList<String> arr= new ArrayList<String>();
		try {
			List<NaturalLanguage> li= new ArrayList<NaturalLanguage>();
		li=curd.findAll(NaturalLanguage.class);
			for(NaturalLanguage nat:li)arr.add(nat.getLanguageName());
			System.out.println(arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
}
