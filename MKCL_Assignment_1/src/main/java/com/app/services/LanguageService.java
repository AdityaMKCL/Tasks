package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.models.NaturalLanguage;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;


public class LanguageService {
	
	public String getAllLanguage() {
		ISql icrud = DALHelper.getIsql();
		List<String> arr= new ArrayList<String>();
		try {
			String str="select n.languageName from NaturalLanguage n";
		arr=icrud.executeQuery(str);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr.toString();
	}
	
}
