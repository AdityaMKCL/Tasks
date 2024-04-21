package com.app.models;

import java.sql.Date;

public class ExamEventPaperDetails {
	
	private long examEventPaperID;
	private long examEventID;
	private Long fkPaperID;
	private int noOfAttempts;	
	private Boolean isRandomOption;
	private String allowAttemptType;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private char deleted;
	private boolean isIdenticalItems;
	private boolean isIdenticalItemSequence;
	private boolean isSkipQuestion;
	private boolean isAnswerChange;
	private boolean showNotepad;
	private boolean palletNavigation;
	public long getExamEventPaperID() {
		return examEventPaperID;
	}
	public void setExamEventPaperID(long examEventPaperID) {
		this.examEventPaperID = examEventPaperID;
	}
	public long getExamEventID() {
		return examEventID;
	}
	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}
	public Long getFkPaperID() {
		return fkPaperID;
	}
	public void setFkPaperID(Long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}
	public int getNoOfAttempts() {
		return noOfAttempts;
	}
	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	public Boolean getIsRandomOption() {
		return isRandomOption;
	}
	public void setIsRandomOption(Boolean isRandomOption) {
		this.isRandomOption = isRandomOption;
	}
	public String getAllowAttemptType() {
		return allowAttemptType;
	}
	public void setAllowAttemptType(String allowAttemptType) {
		this.allowAttemptType = allowAttemptType;
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
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public boolean isIdenticalItems() {
		return isIdenticalItems;
	}
	public void setIdenticalItems(boolean isIdenticalItems) {
		this.isIdenticalItems = isIdenticalItems;
	}
	public boolean isIdenticalItemSequence() {
		return isIdenticalItemSequence;
	}
	public void setIdenticalItemSequence(boolean isIdenticalItemSequence) {
		this.isIdenticalItemSequence = isIdenticalItemSequence;
	}
	public boolean isSkipQuestion() {
		return isSkipQuestion;
	}
	public void setSkipQuestion(boolean isSkipQuestion) {
		this.isSkipQuestion = isSkipQuestion;
	}
	public boolean isAnswerChange() {
		return isAnswerChange;
	}
	public void setAnswerChange(boolean isAnswerChange) {
		this.isAnswerChange = isAnswerChange;
	}
	public boolean isShowNotepad() {
		return showNotepad;
	}
	public void setShowNotepad(boolean showNotepad) {
		this.showNotepad = showNotepad;
	}
	public boolean isPalletNavigation() {
		return palletNavigation;
	}
	public void setPalletNavigation(boolean palletNavigation) {
		this.palletNavigation = palletNavigation;
	}
	
	
}
