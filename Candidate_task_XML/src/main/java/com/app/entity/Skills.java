package com.app.entity;


public class Skills{
	
	private Long sid;
	
    private String name;
	
	private Candidate candi;
	public Skills() {}
	public Skills(String name, Candidate candi) {
		super();
		this.name = name;
		this.candi = candi;
	}
	
	public Long getSid() {
		return sid;
	}
 
	public void setSid(Long sid) {
		this.sid = sid;
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
