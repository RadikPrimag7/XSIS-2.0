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
import com.ngexsis.model.TimePeriodModel;

@Entity
@Table(name = "x_riwayat_proyek")
@Where(clause="is_delete=false")
public class ProjectModel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "X_riwayat_proyek_seq")
	@TableGenerator(name = "x_riwayat_proyek_seq", table = "tbl_sequence", pkColumnName = "seq_id", 
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	
	@Column(name = "id", nullable = false, length = 11)
	private long id;
	
	@Column(name = "created_by", nullable = true, length = 11) 	//supposed to be nullable = false
	private long createdBy;
	
	@Column(name = "created_on", nullable = true) 	//supposed to be nullable = false
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
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deletedOn;
	
	@Column(name = "is_delete")
	private boolean isDelete;
	
	//=====//
	@Column(name = "riwayat_pekerjaan_id", nullable = true, length = 11) //supposed to be nullable = false
	private long riwayatPekerjaanId;
	//=====//
	
	@Column(name = "start_year", nullable = true, length = 10)
	private String startYear;
	
	@Column(name = "start_month", nullable = true, length = 10)
	private String startMonth;
	
	@Column(name = "project_name", nullable = true, length = 50)
	private String projectName;
	
	@Column(name = "project_duration", nullable = true)
	private int projectDuration;
	
	@Column(name = "time_period_id", nullable = true, updatable = false, insertable = false, length = 11)
	private long timePeriodId;
	
	@Column(name = "client", nullable = true, length = 100)
	private String client;
	
	@Column(name = "project_position", nullable = true, length = 100)
	private String projectPosition;
	
	@Column(name = "description", nullable = true, length = 1000)
	private String description;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "time_period_id", foreignKey = @ForeignKey(name = "fk_timePeriod"))
	private TimePeriodModel timePeriod;

	public TimePeriodModel getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriodModel timePeriod) {
		this.timePeriod = timePeriod;
	}

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

	public long getRiwayatPekerjaanId() {
		return riwayatPekerjaanId;
	}

	public void setRiwayatPekerjaanId(long riwayatPekerjaanId) {
		this.riwayatPekerjaanId = riwayatPekerjaanId;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(int projectDuration) {
		this.projectDuration = projectDuration;
	}

	public long getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(long timePeriodId) {
		this.timePeriodId = timePeriodId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getProjectPosition() {
		return projectPosition;
	}

	public void setProjectPosition(String projectPosition) {
		this.projectPosition = projectPosition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
