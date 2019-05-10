package com.ngexsis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_biodata_attachment")
public class DokumenModel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_biodata_attachment_seq")
	@TableGenerator(name = "x_biodata_attachment_seq", table = "tbl_sequence", pkColumnName = "seq_id", 
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	
	@Column(name = "id", nullable = false, length = 11)
	private long id;
	
	//============================================================//
	@Column(name = "created_by", nullable = true, length = 11) 	//supposed to be nullable = false
	private long createdBy;
	
	@Column(name = "created_on", nullable = true) 	//supposed to be nullable = false
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = true) //supposed to be nullable = false
	private boolean isDelete;
	
	@Column(name = "biodata_id", nullable = true, length = 11) //supposed to be nullable = false
	private long biodataId;
	//============================================================//
	
	@Column(name = "file_name", nullable = true, length = 100)
	private String fileName;
	
	@Column(name = "file_path", nullable = true, length = 1000)
	private String filePath;
	
	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;
	
	@Column(name = "is_photo", nullable = true)
	private boolean isPhoto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(long biodataId) {
		this.biodataId = biodataId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isPhoto() {
		return isPhoto;
	}

	public void setPhoto(boolean isPhoto) {
		this.isPhoto = isPhoto;
	}
}
