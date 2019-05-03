package com.ngexsis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="x_education_level")
public class JenjangModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="jenjang_seq")
	@TableGenerator(name="jenjang_seq", table="tbl_sequence_jenjang", pkColumnName="seq_id", valueColumnName="seq_value", initialValue=0, allocationSize=1)
	@Column(name="id", nullable=false, length=11)
	private Long id;
	
	@Column(name="created_by", nullable=true, length=11)
	private Long createdBy;
	
	@Column(name="created_on", nullable=true)
	private Date createdOn;
	
	@Column(name="modified_by", nullable=true, length=11)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	private Date modifiedOn;
	
	@Column(name="deleted_by", nullable=true, length=11)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	private Date deletedOn;
	
	@Column(name="is_delete", nullable=true)
	private Boolean isDelete;
	
	@Column(name="name", nullable=true, length=50)
	private String name;
	
	@Column(name="description", nullable=true, length=100)
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "jenjang", cascade = CascadeType.ALL)
	private List<PendidikanModel> listjenjang= new ArrayList<PendidikanModel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PendidikanModel> getListjenjang() {
		return listjenjang;
	}

	public void setListjenjang(List<PendidikanModel> listjenjang) {
		this.listjenjang = listjenjang;
	}
}
