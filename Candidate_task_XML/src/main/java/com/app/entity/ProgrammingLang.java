package com.app.entity;


public class ProgrammingLang {

	private Long pid;
	
	private String name;
	
	private Candidate candi;
	
	public ProgrammingLang() {}
	
	public ProgrammingLang(String name, Candidate candi) {
		super();
		this.name = name;
		this.candi = candi;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Candidate getCandi() {
		return candi;
	}

	public void setCandi(Candidate candi) {
		this.candi = candi;
	}

}
