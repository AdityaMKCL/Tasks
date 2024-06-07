package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.context.annotation.Bean;

import com.app.entity.Student;

public class DbUtil {
	
	static String jdbcUrl = "jdbc:mysql://localhost:3306/practice";
	static String username = "root";
    static String password = "root@123";
    static Connection con;
    static {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(jdbcUrl,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
    @Bean
	public static Connection getConnection() {
		return con;
	}
}
