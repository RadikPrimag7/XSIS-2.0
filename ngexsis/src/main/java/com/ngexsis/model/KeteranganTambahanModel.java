package com.ngexsis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_keterangan_tambahan")
public class KeteranganTambahanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="keterangan_tambahan_seq")
	@TableGenerator(name="keterangan_tambahan_seq", table="tbl_sequence", pkColumnName="seq_id",
	valueColumnName="seq_value", initialValue=0, allocationSize=1)
	
	@Column(name = "id", nullable = false, length = 11)
	private Long id;
	
	@Column(name = "created_by", nullable = false, length = 11)
	private Long createdBy;
	
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private Long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private Long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = false)
	private boolean isDelete;
	
	/*
	@Column(name = "biodata_id", nullable = false, length = 11)
	private Long biodataId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "biodata_id", foreignKey = @ForeignKey(name = "fk_biodata_sertifikasi"))
	private BiodataModel biodata;
	*/
	
	@Column(name="emergency_contact_name", nullable=true, length=100)
	private String emergencyContactName;
	
	@Column(name="emergency_contact_phone", nullable=true, length=50)
	private String emergencyContactPhone;
	
	@Column(name="expected_salary", nullable=true, length=20)
	private String expectedSalary;
	
	@Column(name="is_negotiable", nullable=true)
	private boolean isNegotiable;
	
	@Column(name="start_working", nullable=true, length=10)
	private String startWorking;
	
	@Column(name="is_ready_to_outoftown", nullable=true)
	private boolean isReadyToOutoftown;
	
	@Column(name="is_apply_other_place", nullable=true)
	private boolean isApplyOtherPlace;
	
	@Column(name="apply_place", nullable=true, length=100)
	private String applyPlace;
	
	@Column(name="selection_phace", nullable=true, length=100)
	private String selectionPhase;
	
	@Column(name="is_ever_badly_sick", nullable=true)
	private boolean isEverBadlySick;
	
	@Column(name="disease_name", nullable=true, length=100)
	private String diseaseName;
	
	@Column(name="disease_time", nullable=true, length=100)
	private String diseaseTime;
	
	@Column(name="is_ever_psychotest", nullable=true)
	private boolean isEverPsychotest;
	
	@Column(name="psychotest_needs", nullable=true, length=100)
	private String psychotestNeeds;
	
	@Column(name="psychotest_time", nullable=true, length=100)
	private String psychotestTime;
	
	@Column(name="requirementes_required", nullable=true, length=500)
	private String requirementesRequired;
	
	@Column(name="other_notes", nullable=true, length=1000)
	private String otherNotes;

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

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public boolean isNegotiable() {
		return isNegotiable;
	}

	public void setNegotiable(boolean isNegotiable) {
		this.isNegotiable = isNegotiable;
	}

	public String getStartWorking() {
		return startWorking;
	}

	public void setStartWorking(String startWorking) {
		this.startWorking = startWorking;
	}

	public boolean isReadyToOutoftown() {
		return isReadyToOutoftown;
	}

	public void setReadyToOutoftown(boolean isReadyToOutoftown) {
		this.isReadyToOutoftown = isReadyToOutoftown;
	}

	public boolean isApplyOtherPlace() {
		return isApplyOtherPlace;
	}

	public void setApplyOtherPlace(boolean isApplyOtherPlace) {
		this.isApplyOtherPlace = isApplyOtherPlace;
	}

	public String getApplyPlace() {
		return applyPlace;
	}

	public void setApplyPlace(String applyPlace) {
		this.applyPlace = applyPlace;
	}

	public String getSelectionPhase() {
		return selectionPhase;
	}

	public void setSelectionPhase(String selectionPhase) {
		this.selectionPhase = selectionPhase;
	}

	public boolean isEverBadlySick() {
		return isEverBadlySick;
	}

	public void setEverBadlySick(boolean isEverBadlySick) {
		this.isEverBadlySick = isEverBadlySick;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseTime() {
		return diseaseTime;
	}

	public void setDiseaseTime(String diseaseTime) {
		this.diseaseTime = diseaseTime;
	}

	public boolean isEverPsychotest() {
		return isEverPsychotest;
	}

	public void setEverPsychotest(boolean isEverPsychotest) {
		this.isEverPsychotest = isEverPsychotest;
	}

	public String getPsychotestNeeds() {
		return psychotestNeeds;
	}

	public void setPsychotestNeeds(String psychotestNeeds) {
		this.psychotestNeeds = psychotestNeeds;
	}

	public String getPsychotestTime() {
		return psychotestTime;
	}

	public void setPsychotestTime(String psychotestTime) {
		this.psychotestTime = psychotestTime;
	}

	public String getRequirementesRequired() {
		return requirementesRequired;
	}

	public void setRequirementesRequired(String requirementesRequired) {
		this.requirementesRequired = requirementesRequired;
	}

	public String getOtherNotes() {
		return otherNotes;
	}

	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}
	
}
