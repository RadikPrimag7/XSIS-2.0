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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "x_test_type")
public class OnlineTestTypeModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "test_type_seq")
	@TableGenerator(name = "test_type_seq", table= "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Long id;
	
	@Column(name = "created_by", nullable = true, length = 11)
	private long createdBy;
	
	@Column(name = "created_on", nullable = true)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = true, columnDefinition = "BOOLEAN DEFAULT false")
	private boolean isDelete;
	
	@Column(name = "name", nullable = true, length = 50)
	private String name;
	
	@Column(name = "description", nullable = true, length = 100)
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "testType", cascade = CascadeType.ALL)
	private List<OnlineTestDetailModel> listTesDetail = new ArrayList<OnlineTestDetailModel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<OnlineTestDetailModel> getListTesDetail() {
		return listTesDetail;
	}

	public void setListTesDetail(List<OnlineTestDetailModel> listTesDetail) {
		this.listTesDetail = listTesDetail;
	}
	
	
}
