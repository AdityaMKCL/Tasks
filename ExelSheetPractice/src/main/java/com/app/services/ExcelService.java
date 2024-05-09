package com.app.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.app.dao.ExcelDao;
import com.app.models.User;

public class ExcelService {

	public String readExcelAndSaveInDB(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			ExcelDao edao = new ExcelDao();
			for(int i=0;i<wb.getNumberOfSheets();i++) {
			Sheet s = wb.getSheetAt(i);
			int row = s.getLastRowNum()+1;
			int col = s.getRow(2).getLastCellNum();
			System.out.println("Number of rows--------------------->"+row);
			System.out.println("Number of cols--------------------->"+col);
			
			List<User> list = new ArrayList<>();
			for(int k=1; k<row; k++) {
				User e = new User();
				for(int j=0; j<col; j++) {
					Row r = s.getRow(k);
					Cell c = r.getCell(j);
					System.out.print("Im here");
					
					
						String data = c.getStringCellValue();
						
						if(j==0) {
							e.setName(data);
						}
						else if(j==1) {
							e.setCity(data);
						}
				}
				list.add(e);
				
			}
			
			String ans =edao.addUsers(list);
			System.out.println("---------------------------->"+list);
//			return "";
			 
			}
			return "done";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "something wrong";
	}
	public ArrayList<User> readExcelAndReturnList(String path) {
		List<User> list1 = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			ExcelDao edao = new ExcelDao();
			for(int i=0;i<wb.getNumberOfSheets();i++) {
				Sheet s = wb.getSheetAt(i);
				int row = s.getLastRowNum()+1;
				int col = s.getRow(2).getLastCellNum();
				System.out.println("Number of rows--------------------->"+row);
				System.out.println("Number of cols--------------------->"+col);
				
				List<User> list = new ArrayList<>();
				for(int k=1; k<row; k++) {
					User e = new User();
					for(int j=0; j<col; j++) {
						Row r = s.getRow(k);
						Cell c = r.getCell(j);
						System.out.print("Im here");
						
						
							String data = c.getStringCellValue();
							
							if(j==0) {
								e.setName(data);
							}
							else if(j==1) {
								e.setCity(data);
							}
					}
					list.add(e);
					
				}
				list1.addAll(list);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<User>) list1;
		
	}
	
	public ArrayList<String> getZipList(){
		List<String> li= new ArrayList<String>();
		
		li=Stream.of(new File("C:\\Users\\adityak\\Desktop\\sts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ExelSheetPractice\\Files").listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toList());
		return (ArrayList<String>) li;
	}
		
	
}
