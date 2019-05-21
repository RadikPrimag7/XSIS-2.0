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
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="x_riwayat_pelatihan")
@Where(clause = "is_delete = false")
public class PelatihanModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pelatihan_seq")
	@TableGenerator(name = "pelatihan_seq", table = "tbl_sequence", pkColumnName = "seq_id",
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
	@CreationTimestamp
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
	private BiodataModel biodataPelatihan;
	
	@Column(name = "training_name", nullable = true, length = 100)
	private String trainingName;
	
	@Column(name = "organizer", nullable = true, length = 50)
	private String oganizer;
	
	@Column(name = "training_year", nullable = true, length = 10)
	private String trainingYear;
	@Column(name = "training_month", nullable = true, length = 10)
	private String trainingMonth;
	
	@Column(name = "training_duration", nullable = true)
	private int trainingDuration;
	
	@Column(name = "time_period_id", nullable = true, length = 11,updatable = false, insertable = false)
	private long timePeriodId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="time_period_id", foreignKey = @ForeignKey(name ="fk_time_period"))
	private TimePeriodModel periodId;
	
	@Column(name = "city", nullable = true, length = 50)
	private String city;
	
	@Column(name = "country", nullable = true, length = 50)
	private String country;
	
	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;
	
	public BiodataModel getBiodataPelatihan() {
		return biodataPelatihan;
	}
	public void setBiodataPelatihan(BiodataModel biodata) {
		this.biodataPelatihan = biodata;
	}
	
	public TimePeriodModel getPeriodId() {
		return periodId;
	}
	public void setPeriodId(TimePeriodModel periodId) {
		this.periodId = periodId;
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
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getOganizer() {
		return oganizer;
	}
	public void setOganizer(String oganizer) {
		this.oganizer = oganizer;
	}
	public String getTrainingYear() {
		return trainingYear;
	}
	public void setTrainingYear(String trainingYear) {
		this.trainingYear = trainingYear;
	}
	public String getTrainingMonth() {
		return trainingMonth;
	}
	public void setTrainingMonth(String trainingMonth) {
		this.trainingMonth = trainingMonth;
	}
	public int getTrainingDuration() {
		return trainingDuration;
	}
	public void setTrainingDuration(int trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
	public long getTimePeriodId() {
		return timePeriodId;
	}
	public void setTimePeriodId(long timePeriodId) {
		this.timePeriodId = timePeriodId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
