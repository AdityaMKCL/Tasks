package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.entity.Student;
import com.app.utils.DbUtil;

public class StudentDao {
	static Connection con=DbUtil.getConnection();
	
	public boolean addStudent(Student s) {
		boolean flag=true;
		
	    try {
		PreparedStatement smt=con.prepareStatement("insert into student values(default,?,?,?,?)");
		smt.setString(1, s.getName());
		smt.setInt(2, s.getMarks());
		smt.setString(3, s.getSchool());
		smt.setString(4, s.getEmail());
		smt.executeUpdate();
	    }catch(Exception e) {
	    	flag=false;
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	public ArrayList<Student> getAll(){
		ArrayList<Student> arr=new ArrayList<Student>();
		try {
			
		 PreparedStatement statement = con.prepareStatement("select * from student"); 
         
         ResultSet resultSet = statement.executeQuery(); 
         System.out.println("The Available Data\n"); 
           
         // Iterate over the result set and print the retrieved data 
         while (resultSet.next()) { 
             int roll = resultSet.getInt("roll"); 
             String name = resultSet.getString("name"); 
             int marks = resultSet.getInt("marks");
             String school = resultSet.getString("school"); 
             String email=resultSet.getString("email");
             Student s=new Student(roll,name,marks,school,email);
             arr.add(s);
         } 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public boolean deleteStudent(Integer roll) {
		boolean flag=true;
		try {
		 PreparedStatement statement = con.prepareStatement("delete from student where roll=?");
		 statement.setInt(1, roll);
		 statement.executeUpdate();
		 
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
	public Student getStudent(Integer roll) {
		boolean flag=true;
		try {
		 PreparedStatement statement = con.prepareStatement("select * from student where roll=?");
		 statement.setInt(1, roll);
		 ResultSet rs=statement.executeQuery();
		 rs.next();
		 System.out.println(rs.getInt("roll"));
		 Student s=new Student(rs.getInt("roll"),rs.getString("name"),rs.getInt("marks"),rs.getString("school"),rs.getString("email"));
		 return s;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateStudent(Student s) {
		boolean flag=true;
		System.out.println("inside student update ");
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE student SET name=?,marks=?,school=?,email=? WHERE roll=?;");
			statement.setString(1, s.getName());
			statement.setInt(2, s.getMarks());
			statement.setString(3, s.getSchool());
			statement.setInt(5, s.getRoll());
			statement.setString(4, s.getEmail());
			
			int ans=statement.executeUpdate();
			System.out.println(ans);
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
