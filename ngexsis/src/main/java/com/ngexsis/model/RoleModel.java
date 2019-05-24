package com.ngexsis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_role",
		uniqueConstraints = {
		@UniqueConstraint(name="x_role_uk", columnNames= "code")
		})
@Where(clause="is_delete=false")
public class RoleModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="role_seq")
	@TableGenerator(name="role_seq", table="tbl_sequence_role", pkColumnName="seq_id", valueColumnName="seq_value", initialValue=0, allocationSize=1)
	@Column(name="id", nullable=false, length=11)
	private Long Id;
	
	@Column(name="code",nullable=false, length=50, unique=true)
	private String code;
	
	@Column(name="name",nullable=false, length=50)
	private String name;
	
	@Column(name="created_by", nullable=true, length=11)
	private Long createdBy;
	
	@Column(name="created_on", nullable=true)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdOn;
	
	@Column(name="modified_by", nullable=true, length=11)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedOn;
	
	@Column(name="deleted_by", nullable=true, length=11)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deletedOn;
	
	@Column(name="is_delete", nullable=true)
	private boolean isDelete;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
