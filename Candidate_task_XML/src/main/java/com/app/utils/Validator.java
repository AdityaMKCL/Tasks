package com.app.utils;

import com.app.entity.Candidate;

public class Validator {

	public static String validate(Candidate c) {
		String answer="";
		
		String regex="^[a-zA-Z]+ ?([a-zA-Z]+$){1}";
		if(!c.getCandidate_name().matches(regex))answer+="Name ";
		regex = "^[a-zA-Z0-9]+$";
		if(!c.getUser_name().matches(regex))answer+="User Name ";
		regex="^(?=.*?[a-zA-Z0-9#?!@$%^&*-])(?=.*?[a-zA-Z0-9#?!@$%^&*-])(?=.*?[a-zA-Z0-9#?!@$%^&*-]).{8,}$";
		if(!c.getPassword().matches(regex))answer+="Password";
		return answer;
	}
	
}
