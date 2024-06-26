package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Candidate extends BaseEntity{
	
	
	private String candidate_name ;
	
	private String user_name;
	
	private String password;
	
	private String description;
	
	@Enumerated(EnumType. STRING)
	private Gender gender;
	
	private Integer standard;
	
	@OneToMany(mappedBy = "candi")
	List<ProgrammingLang> languages;
	
	@OneToMany(mappedBy = "candi")
	List<Skills> skills;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id")
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
