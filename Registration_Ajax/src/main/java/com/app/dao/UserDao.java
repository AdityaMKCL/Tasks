package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.entity.User;
import com.app.utils.DbUtils;

public class UserDao {
	static Connection con=DbUtils.getConnection();
	public ArrayList<User> getAll(){
		ArrayList<User> arr=new ArrayList<User>();
		try {
		PreparedStatement stmt=con.prepareStatement("SELECT uid,fname,lname,c.name city,s.name state "
				+ "FROM users u LEFT JOIN states s ON u.sid=s.stateId "
				+ "LEFT JOIN cities c ON u.cid=c.cid;");
		
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			int uid=rs.getInt("uid");
			String fname=rs.getString("fname");
			String lname=rs.getString("lname");
			String state=rs.getString("state");
			String city=rs.getString("city");
			User use=new User(uid,fname,lname,state,city);
			arr.add(use);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public ArrayList<String> getStates(){
		ArrayList<String> arr= new ArrayList<String>();
		try{
			PreparedStatement stm=con.prepareStatement("select name from states");
			ResultSet rs= stm.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				arr.add(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public ArrayList<String> getCities(String sid)
	{
		ArrayList<String> arr = new ArrayList<String>();
		try {
			PreparedStatement smt=con.prepareStatement("SELECT c.name FROM cities c,states s WHERE s.name=? AND c.sid=s.stateId ;");
			smt.setString(1,sid);
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				arr.add(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public boolean saveUser(User u)
	{
		int flag=-1;
		try {
			u.toString();
			PreparedStatement smt=con.prepareStatement("INSERT INTO users VALUES (DEFAULT,?,?,(SELECT s.stateId FROM states s WHERE s.name=?),(SELECT c.cid FROM cities c WHERE c.name=?));");
			smt.setString(1,u.getFname());
			smt.setString(2,u.getLname());
			smt.setString(3, u.getState());
			smt.setString(4, u.getCity());
		System.out.println(	smt.toString());
			flag=smt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag==-1)return false;
		return true;
	}
	public boolean deleteUser(Integer roll) {
		boolean flag=true;
		try {
		 PreparedStatement statement = con.prepareStatement("delete from users where uid=?");
		 statement.setInt(1, roll);
		 statement.executeUpdate();
		 
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
