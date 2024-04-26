package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.models.ExamEventPaperDetails;
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

	public ArrayList<Paper> getAllPapersList(Long exameventId) {

		ExamEventPaperDao edao= new ExamEventPaperDao();
		ArrayList<Long> arr= new ArrayList<>();
		ArrayList<Paper> arr1= new ArrayList<>();
		
		arr=edao.getEventPapers(exameventId);
		try {
			String hql = "SELECT  e FROM " + Paper.class.getName() + " e WHERE e.paperID in (" + arr.toString().substring(1, arr.size()+arr.size()+arr.size()-1) +")";
			List<Paper> li = new ArrayList<Paper>();
			li =  curd.executeQuery(hql);
			 arr1=(ArrayList<Paper>) li;
			 System.out.println("inside exameventdetaildao");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return arr1;
	}

	public String getAllPapersListByEvent(Long id) {
		System.out.println("inside the main dao ");
		String answer="";
		List<ExamEventPaperDetails> li= new ArrayList<>();
		try {
			li=curd.findBy(ExamEventPaperDetails.class, "examEventID", id);
			ArrayList<Long> arr= new ArrayList<Long>();
			for(ExamEventPaperDetails e: li) {
					arr.add(e.getFkPaperID());
					System.out.println(e.getFkPaperID());
			}
			answer=arr.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	public String getAllFullPapersByEvent(Long id) {
		List<String> arr= new ArrayList<>();
		String ans= "";
		try {
			String hql = "SELECT  p.name,p.paperID FROM " + Paper.class.getName() + " p , "+ ExamEventPaperDetails.class.getName()+" e WHERE e.examEventID =" + id +" and e.fkPaperID=p.paperID ";
			 arr =curd.executeQuery(hql);
			 System.out.println("inside exameventdetaildao");
			ans=arr.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
}
