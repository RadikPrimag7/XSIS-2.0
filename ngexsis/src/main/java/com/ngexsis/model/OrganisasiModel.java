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
@Table(name = "x_organisasi")
public class OrganisasiModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_organisasi_seq")
	@TableGenerator(name = "x_organisasi_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	
	@Column(name = "id", nullable = false, length = 11)
	private long id;
	
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
	
	@Column(name = "biodata_id", nullable = true, length = 11) 	//supposed to be nullable = false
	private long biodataid;
	
	@Column(name = "name", nullable = true, length = 100)
	private String name;
	
	@Column(name = "position", nullable = true, length = 100)
	private String position;
	
	@Column(name = "entry_year", nullable = true, length = 10)
	private String entryYear;
	
	@Column(name = "exit_year", nullable = true, length = 10)
	private String exitYear;
	
	@Column(name = "responsibility", nullable = true, length = 100)
	private String responsibility;
	
	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;

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
	
	public long getBiodataid() {
		return biodataid;
	}

	public void setBiodataid(long biodataid) {
		this.biodataid = biodataid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getExitYear() {
		return exitYear;
	}

	public void setExitYear(String exitYear) {
		this.exitYear = exitYear;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
