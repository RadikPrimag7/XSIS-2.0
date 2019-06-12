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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "x_online_tes_detail")
public class OnlineTestDetailModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Online_tes_detail_seq")
	@TableGenerator(name = "Online_tes_detail_seq", table= "tbl_sequence", pkColumnName = "seq_id",
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
	
	@Column(name = "online_tes_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long onlineTestId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "online_tes_id", foreignKey = @ForeignKey(name = "fk_onlineTes"))
	private OnlineTesModel Ontes;
	
	@Column(name = "test_type_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long tesTypeId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "test_type_id", foreignKey = @ForeignKey(name = "fk_test_type"))
	private OnlineTestTypeModel testType;
	
	@Column(name = "test_order", nullable = true)
	private int testOrder;

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

	public long getOnlineTestId() {
		return onlineTestId;
	}

	public void setOnlineTestId(long onlineTestId) {
		this.onlineTestId = onlineTestId;
	}

	public OnlineTesModel getOntes() {
		return Ontes;
	}

	public void setOntes(OnlineTesModel ontes) {
		Ontes = ontes;
	}

	public long getTesTypeId() {
		return tesTypeId;
	}

	public void setTesTypeId(long tesTypeId) {
		this.tesTypeId = tesTypeId;
	}

	public OnlineTestTypeModel getTestType() {
		return testType;
	}

	public void setTestType(OnlineTestTypeModel testType) {
		this.testType = testType;
	}

	public int getTestOrder() {
		return testOrder;
	}

	public void setTestOrder(int testOrder) {
		this.testOrder = testOrder;
	}
	
	
	
}
