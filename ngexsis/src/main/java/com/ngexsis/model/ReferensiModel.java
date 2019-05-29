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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "x_pe_referensi")
@Where(clause="is_delete=false")
public class ReferensiModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="referensi_seq")
	@TableGenerator(name="referensi_seq", table="tbl_sequence", pkColumnName="seq_id",
	valueColumnName="seq_value", initialValue=0, allocationSize=1)
	
	@Column(name="id", nullable=false, length=11)
	private Long id;
	
	@Column(name="created_by", nullable=false, length=11)
	private Long createdBy;
	
	@Column(name="created_on", nullable=false)
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
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;
	
	
	@Column(name = "biodata_id", nullable = false, length = 11, updatable = false, insertable = false)
	private Long biodataId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "biodata_id", foreignKey = @ForeignKey(name = "fk_biodata_referensi"))
	private BiodataModel biodataReferensi;
	
	
	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public BiodataModel getBiodataReferensi() {
		return biodataReferensi;
	}

	public void setBiodataReferensi(BiodataModel biodataReferensi) {
		this.biodataReferensi = biodataReferensi;
	}

	@Column(name="name", nullable=true, length=100)
	private String name;
	
	@Column(name="position", nullable=true, length=100)
	private String position;
	
	@Column(name="address_phone", nullable=true, length=1000)
	private String addressPhone;
	
	@Column(name="relation", nullable=true, length=100)
	private String relation;

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}
