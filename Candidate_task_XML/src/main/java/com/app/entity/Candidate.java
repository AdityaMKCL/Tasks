package com.app.entity;
import java.util.Set;

import javax.persistence.Transient;


public class Candidate{
	
	private Long id;
	
	private String candidate_name ;
	
	private String user_name;
	
	private String password;
	
	private String description;
	
	private Gender gender;
	
	private Integer standard;
	
	@Transient
	Set<ProgrammingLang> languages;
	
	Set<Skills> skills;
	
	private File file;

	public Candidate() {}
	

	public Candidate(String candidate_name, String user_name, String password, String description, Gender gender,
			Integer standard) {
		super();
		this.candidate_name = candidate_name;
		this.user_name = user_name;
		this.password = password;
		this.description = description;
		this.gender = gender;
		this.standard = standard;
	}

	public Long getId() {
		return id;
	}
	
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	


	public Set<ProgrammingLang> getLanguages() {
		return languages;
	}


	public void setLanguages(Set<ProgrammingLang> languages) {
		this.languages = languages;
	}


	public Set<Skills> getSkills() {
		return skills;
	}


	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public void addLanguage(ProgrammingLang lang) {
		languages.add(lang);
	}
	public void removeLanguage(ProgrammingLang lang) {
		languages.remove(lang);
	}
	public void addSkill(Skills lang) {
		skills.add(lang);
	}
	public void removeSkill(Skills lang) {
		skills.remove(lang);
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Candidate [candidate_name=" + candidate_name + ", user_name=" + user_name + ", password=" + password
				+ ", description=" + description + ", gender=" + gender + ", standard=" + standard + "]";
	}
	
}
