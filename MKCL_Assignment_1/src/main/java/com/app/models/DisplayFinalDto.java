package com.app.models;

import java.util.Date;

public class DisplayFinalDto {
	private String event;
	private String paper;
	private Date startDate;
	private Date endDate;
	public DisplayFinalDto() {}
	
	public DisplayFinalDto(String event, String paper, Date startDate, Date endDate) {
		super();
		this.event = event;
		this.paper = paper;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return  event + "," + paper + "," + startDate + ","
				+ endDate;
	}
	
	
}
