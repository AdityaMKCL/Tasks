package com.app.models;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Paper {

	// @@fields@@//
	// @@PK@@//
	private long paperID;
	private long fkClientID;
	private String code;
	private String name;
	private String duration;
	private int isPublished;
	// @@fields@@//
	private java.sql.Date dateCreated;
	private String createdBy;
	private java.sql.Date dateModified;
	private String modifiedBy;
	private char deleted;
	private String Total_Marks_Check;
//		private List<NaturalLanguage>languageList;
//		private List<PaperItemBankAssociation> paperItemBankAssociationList;
//		private List<Section> sectionList; 

	/**
	 * @return the total_Marks_Check
	 */
	public String getTotal_Marks_Check() {
		return Total_Marks_Check;
	}

	/**
	 * @param total_Marks_Check the total_Marks_Check to set
	 */
	public void setTotal_Marks_Check(String total_Marks_Check) {
		Total_Marks_Check = total_Marks_Check;
	}

	/**
	 * @return the deleted
	 */
	public char getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the paperID
	 */
	public long getPaperID() {
		return paperID;
	}

	/**
	 * @param paperID the paperID to set
	 */
	public void setPaperID(long paperID) {
		this.paperID = paperID;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the fkClientID
	 */
	public long getFkClientID() {
		return fkClientID;
	}

	/**
	 * @param fkClientID the fkClientID to set
	 */
	public void setFkClientID(long fkClientID) {
		this.fkClientID = fkClientID;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(int isPublished) {
		this.isPublished = isPublished;
	}

	public java.sql.Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(java.sql.Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.sql.Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(java.sql.Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "[" + paperID + "," + code + "," + name + "]";
	}

	/**
	 * @return the languageList
	 */
//		public List<NaturalLanguage> getLanguageList() {
//			return languageList;
//		}
	/**
	 * @param languageList the languageList to set
	 */
//		public void setLanguageList(List<NaturalLanguage> languageList) {
//			this.languageList = languageList;
//		}
	/**
	 * @return the paperItemBankAssociationList
	 */
//		public List<PaperItemBankAssociation> getPaperItemBankAssociationList() {
//			return paperItemBankAssociationList;
//		}
	/**
	 * @param paperItemBankAssociationList the paperItemBankAssociationList to set
	 */
//		public void setPaperItemBankAssociationList(
//				List<PaperItemBankAssociation> paperItemBankAssociationList) {
//			this.paperItemBankAssociationList = paperItemBankAssociationList;
//		}
//		
//		public List<Section> getSectionList() {
//			return sectionList;
//		}
//		public void setSectionList(List<Section> sectionList) {
//			this.sectionList = sectionList;
//		}

}
