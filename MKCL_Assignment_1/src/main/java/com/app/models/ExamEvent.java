package com.app.models;


import java.io.Serializable;
import java.util.Date;
//import java.util.List;


public class ExamEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long examEventID;
	private long clientID;
	private String examEventCode;
	private String name;
	private Date startDate;
	private Date endDate;
	private Boolean isActiveEvent;
	private String defaultLanguageID;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String eventCategory;
	private String eventType;
	private Boolean  examEventState;

	
	public ExamEvent(String examEventCode, String name, Date startDate, Date endDate, String defaultLanguageID) {
		super();
		this.examEventCode = examEventCode;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.defaultLanguageID = defaultLanguageID;
	}

	public ExamEvent() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getExamEventID() {
		return examEventID;
	}
	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}
	public long getClientID() {
		return clientID;
	}
	public void setClientID(long clientID) {
		this.clientID = clientID;
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
	public String getExamEventCode() {
		return examEventCode;
	}
	public void setExamEventCode(String examEventCode) {
		this.examEventCode = examEventCode;
	}
	public Boolean getIsActiveEvent() {
		return isActiveEvent;
	}
	public void setIsActiveEvent(Boolean isActiveEvent) {
		this.isActiveEvent = isActiveEvent;
	}
	public String getDefaultLanguageID() {
		return defaultLanguageID;
	}
	public void setDefaultLanguageID(String defaultLanguageID) {
		this.defaultLanguageID = defaultLanguageID;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Boolean getExamEventState() {
		return examEventState;
	}
	public void setExamEventState(Boolean examEventState) {
		this.examEventState = examEventState;
	}
//	private transient List<ExamEventPaperDetails> listExamEventPaperDetails;
//	
//	private List<ExamEventScheduleTypeAssociation> examEventScheduleTypeAssociationList;
	// added by reena for Mastering Jee 2014-15 on 28May2014

	@Override
	public String toString() {
		return "ExamEvent [examEventID=" + examEventID + ", clientID=" + clientID + ", examEventCode=" + examEventCode
				+ ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", isActiveEvent="
				+ isActiveEvent + ", defaultLanguageID=" + defaultLanguageID + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", modifiedBy=" + modifiedBy + ", dateModified=" + dateModified
				+  ", eventCategory=" + eventCategory + ", eventType=" + eventType
				+ ", examEventState=" + examEventState + "]";
	}
	
	

	
}

