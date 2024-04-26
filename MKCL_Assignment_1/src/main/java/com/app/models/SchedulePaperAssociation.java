package com.app.models;

import java.sql.Date;

public class SchedulePaperAssociation {

	
	private long schedulePaperAssociationID;
	private long fkExamEventID;
	private long fkScheduleID;
	private long fkPaperID;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private boolean isActive;
	
	public long getSchedulePaperAssociationID() {
		return schedulePaperAssociationID;
	}
	public void setSchedulePaperAssociationID(long schedulePaperAssociationID) {
		this.schedulePaperAssociationID = schedulePaperAssociationID;
	}
	public long getFkExamEventID() {
		return fkExamEventID;
	}
	public void setFkExamEventID(long fkExamEventID) {
		this.fkExamEventID = fkExamEventID;
	}
	public long getFkScheduleID() {
		return fkScheduleID;
	}
	public void setFkScheduleID(long fkScheduleID) {
		this.fkScheduleID = fkScheduleID;
	}
	public long getFkPaperID() {
		return fkPaperID;
	}
	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
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
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

    
}
