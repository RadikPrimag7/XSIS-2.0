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
@Table(name = "x_sertifikasi")
@Where(clause="is_delete=false")

public class SertifikasiModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sertifikasi_seq")
	@TableGenerator(name = "sertifikasi_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	
	@Column(name = "id", nullable = false, length = 11)
	private Long id;
	
	@Column(name = "created_by", nullable = false, length = 11)
	private Long createdBy;
	
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	@DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private Long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private Long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = false)
	private boolean isDelete;
	
	
	@Column(name = "biodata_id", nullable = false, length = 11, updatable = false, insertable = false)
	private Long biodataId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "biodata_id", foreignKey = @ForeignKey(name = "fk_biodata_sertifikasi"))
	private BiodataModel biodataSertifikasi;
	
	
	@Column(name = "certificate_name", nullable = true, length = 200)
	private String certificateName;
	
	@Column(name = "publisher", nullable = true, length = 100)
	private String publisher;
	
	@Column(name = "valid_start_year", nullable = true, length = 10)
	private String validStartYear;
	
	@Column(name = "valid_start_month", nullable = true, length = 10)
	private String validStartMonth;
	
	@Column(name = "until_year", nullable = true, length = 10)
	private String untilYear;
	
	@Column(name = "until_month", nullable = true, length = 10)
	private String untilMonth;
	
	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public BiodataModel getBiodataSertifikasi() {
		return biodataSertifikasi;
	}

	public void setBiodataSertifikasi(BiodataModel biodataSertifikasi) {
		this.biodataSertifikasi = biodataSertifikasi;
	}

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

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getValidStartYear() {
		return validStartYear;
	}

	public void setValidStartYear(String validStartYear) {
		this.validStartYear = validStartYear;
	}

	public String getValidStartMonth() {
		return validStartMonth;
	}

	public void setValidStartMonth(String validStartMonth) {
		this.validStartMonth = validStartMonth;
	}

	public String getUntilYear() {
		return untilYear;
	}

	public void setUntilYear(String untilYear) {
		this.untilYear = untilYear;
	}

	public String getUntilMonth() {
		return untilMonth;
	}

	public void setUntilMonth(String untilMonth) {
		this.untilMonth = untilMonth;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
