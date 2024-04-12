package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skills extends BaseEntity{
	
    private String name;
	
	@ManyToOne
	@JoinColumn(name="cid" ,nullable = false)
	private Candidate candi;

	public Skills(String name, Candidate candi) {
		super();
		this.name = name;
		this.candi = candi;
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
