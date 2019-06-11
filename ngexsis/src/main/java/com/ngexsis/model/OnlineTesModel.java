package com.ngexsis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "x_online_tes")
public class OnlineTesModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "online_tes_seq")
	@TableGenerator(name = "online_tes_seq", table = "tbl_sequence", pkColumnName = "seq_id", valueColumnName = "seq_value",
	initialValue = 0, allocationSize = 1)
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
	
	@Column(name = "biodata_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long biodataId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="biodata_id", foreignKey = @ForeignKey(name ="fk_biodata"))
	private BiodataModel biodataTesOnline;
	
	@Column(name = "period_code", nullable = true, length = 50)
	private String periodCode;
	
	@Column(name = "period", nullable = true)
	private int period;
	
	@Column(name = "tes_date", nullable = true)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date testDate;
	
	@Column(name = "expired_tes", nullable = true)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date expiredTest;
	
	@Column(name = "user_access", nullable = true, length = 10)
	private String userAccess;
	
	@Column(name = "status", nullable = true, length = 50)
	private String status;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "Ontes", cascade = CascadeType.ALL)
	private List<OnlineTestDetailModel> ListOntes = new ArrayList<OnlineTestDetailModel>();
	
	
	public List<OnlineTestDetailModel> getListOntes() {
		return ListOntes;
	}

	public void setListOntes(List<OnlineTestDetailModel> listOntes) {
		ListOntes = listOntes;
	}

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

	public long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(long biodataId) {
		this.biodataId = biodataId;
	}

	public BiodataModel getBiodataTesOnline() {
		return biodataTesOnline;
	}

	public void setBiodataTesOnline(BiodataModel biodataTesOnline) {
		this.biodataTesOnline = biodataTesOnline;
	}

	public String getPeriodCode() {
		return periodCode;
	}

	public void setPeriodCode(String periodCode) {
		this.periodCode = periodCode;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getExpiredTest() {
		return expiredTest;
	}

	public void setExpiredTest(Date expiredTest) {
		this.expiredTest = expiredTest;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
