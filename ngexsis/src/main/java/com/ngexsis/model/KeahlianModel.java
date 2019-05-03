package com.ngexsis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "x_keahlian")
public class KeahlianModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "keahlian_seq")
	@TableGenerator(name = "keahlian_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private long id;
	
	@Column(name = "created_by", nullable = true, length = 11)
	private long createdBy;
	
	@Column(name = "created_on", nullable = true)
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	private Date deletedOn;
	
	@Column(name = "is_delete")
	private boolean isDelete;
	
	
	@Column(name = "biodata_id", nullable = true, length = 11)
	private long biodataId;
	
	@Column(name = "skill_name", nullable = true, length = 100)
	private String skillName;
	
	@Column(name = "skill_level_id", nullable = true,  updatable = false, insertable = false, length = 11)
	private long skillLevelId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "skill_level_id", foreignKey = @ForeignKey(name = "fk_skillLevel"))
	private SkillLevelModel skillLevel;
	
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

	public long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(long biodataId) {
		this.biodataId = biodataId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public long getSkillLevelId() {
		return skillLevelId;
	}

	public void setSkillLevelId(long skillLevelId) {
		this.skillLevelId = skillLevelId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

	public SkillLevelModel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevelModel skillLevel) {
		this.skillLevel = skillLevel;
	}

}
