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
@Table(name="x_riwayat_pendidikan")
public class PendidikanModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="pendidikan_seq")
	@TableGenerator(name="pendidikan_seq", table="tbl_sequence_pendidikan", pkColumnName="seq_id", valueColumnName="seq_value", initialValue=0, allocationSize=1)
	@Column(name="id", nullable=false, length=11)
	private Long id;
	
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
	
	@Column(name="is_delete", nullable=true, columnDefinition="BOOLEAN DEFAULT false")
	private Boolean isDelete;
	
	@Column(name="biodata_id", nullable=true, length=11)
	private Long biodataId;
	
//	@JsonBackReference
//	@JoinColumn(name="biodata_id", foreignKey = @ForeignKey(name="fk_biodata"), updatable=false, insertable=false)
//	private BiodataModel biodata;
	
	@Column(name="school_name", nullable=true, length=100)
	private String schoolName;
	
	@Column(name="city", nullable=true, length=50)
	private String city;
	
	@Column(name="country", nullable=true, length=50)
	private String country;
	
	@Column(name="education_level_id", nullable=true, updatable=false, insertable=false, length=11)
	private Long educationLevelId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="education_level_id", foreignKey = @ForeignKey(name="fk_educationLevel"))
	private EducationLvlModel jenjang;
	
	@Column(name="entry_year", nullable=true, length=10)
	private String entryYear;
	
	@Column(name="graduation_year", nullable=true, length=10)
	private String graduationYear;
	
	@Column(name="major", nullable=true, length=100)
	private String major;
	
	@Column(name="gpa", nullable=true)
	private Double gpa;
	
	@Column(name="notes", nullable=true, length=1000)
	private String notes;
	
	@Column(name="in_order", nullable=true)
	private int inOrder;
	
	@Column(name="judul_ta", nullable=true, length=255)
	private String judulTa;
	
	@Column(name="deskripsi_ta", nullable=true, length=5000)
	private String deskripsiTa;

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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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

	public Long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public EducationLvlModel getJenjang() {
		return jenjang;
	}

	public void setJenjang(EducationLvlModel jenjang) {
		this.jenjang = jenjang;
	}

	public String getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getInOrder() {
		return inOrder;
	}

	public void setInOrder(int inOrder) {
		this.inOrder = inOrder;
	}

	public String getJudulTa() {
		return judulTa;
	}

	public void setJudulTa(String judulTa) {
		this.judulTa = judulTa;
	}

	public String getDeskripsiTa() {
		return deskripsiTa;
	}

	public void setDeskripsiTa(String deskripsiTa) {
		this.deskripsiTa = deskripsiTa;
	}
}
