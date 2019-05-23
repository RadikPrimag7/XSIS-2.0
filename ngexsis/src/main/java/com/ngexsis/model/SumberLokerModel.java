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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name="x_sumber_loker")
public class SumberLokerModel{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sumberloker_seq")
	@TableGenerator(name = "sumberloker_seq", table ="tbl_sequence", pkColumnName = "seq_id",
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
	private BiodataModel biodataSumber;
	
	

	@Column(name = "vacancy_source_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long vacancySourceId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "vacancy_source_id", foreignKey = @ForeignKey(name = "fk_vacancySource"))
	private VacancySauceModel vacancySource;
	
	@Column(name = "candidate_type", nullable = true, length = 10)
	private String candidateType;
	
	@Column(name = "event_name", nullable = true, length = 100)
	private String eventName;
	
	@Column(name = "career_center_name", nullable = true, length = 100)
	private String careerCenterName;
	
	@Column(name = "referrer_name", nullable = true, length = 100)
	private String referrerName;
	
	@Column(name = "referrer_phone", nullable = true, length = 100)
	private String referrerPhone;
	
	@Column(name = "referrer_email", nullable = true, length = 100)
	private String referrerEmail;
	
	@Column(name = "last_income", nullable = true, length = 20)
	private String lastIncome;
	
	@Column(name = "apply_date", nullable = true)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applyDate;
	
	@Column(name = "is_process", nullable = true)
	private boolean isProcess;
	
	
	
	
	public BiodataModel getBiodataSumber() {
		return biodataSumber;
	}

	public void setBiodataSumber(BiodataModel biodataSumber) {
		this.biodataSumber = biodataSumber;
	}

	public VacancySauceModel getVacancySource() {
		return vacancySource;
	}

	public void setVacancySource(VacancySauceModel vacancySource) {
		this.vacancySource = vacancySource;
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

	public long getVacancySourceId() {
		return vacancySourceId;
	}

	public void setVacancySourceId(long vacancySourceId) {
		this.vacancySourceId = vacancySourceId;
	}

	public String getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(String candidateType) {
		this.candidateType = candidateType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCareerCenterName() {
		return careerCenterName;
	}

	public void setCareerCenterName(String careerCenterName) {
		this.careerCenterName = careerCenterName;
	}

	public String getReferrerName() {
		return referrerName;
	}

	public void setReferrerName(String referrerName) {
		this.referrerName = referrerName;
	}

	public String getReferrerPhone() {
		return referrerPhone;
	}

	public void setReferrerPhone(String referrerPhone) {
		this.referrerPhone = referrerPhone;
	}

	public String getReferrerEmail() {
		return referrerEmail;
	}

	public void setReferrerEmail(String referrerEmail) {
		this.referrerEmail = referrerEmail;
	}

	public String getLastIncome() {
		return lastIncome;
	}

	public void setLastIncome(String lastIncome) {
		this.lastIncome = lastIncome;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public boolean isProcess() {
		return isProcess;
	}

	public void setProcess(boolean isProcess) {
		this.isProcess = isProcess;
	}
	
	



}
