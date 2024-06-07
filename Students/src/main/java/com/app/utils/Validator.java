package com.app.utils;

public class Validator {

	public boolean emailValidator(String email) {
		String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		return email.matches(EMAIL_VERIFICATION);
	}
	
	public boolean marksValidator(int marks) {
		if(marks >=0 && marks<=100)return true;
		return false;
	}
	
	public boolean nameValidator(String name) {
		String regex="^[a-zA-Z\\s]+";
		boolean flag=false;
		for(int i=0;i<name.length();i++) {
			Character c= name.charAt(i);
			if(c.isLetter(c))flag=true;
		}
		if(flag==false)return false;
		return name.matches(regex);
	}
	public boolean schoolValidator(String school) {
		String regex="^[a-zA-Z\\s]+";
		boolean flag=false;
		for(int i=0;i<school.length();i++) {
			Character c= school.charAt(i);
			if(c.isLetter(c))flag=true;
		}
		if(flag==false)return false;
		return school.matches(regex);
	}
}
