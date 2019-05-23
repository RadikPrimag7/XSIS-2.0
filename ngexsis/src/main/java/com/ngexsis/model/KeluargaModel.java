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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "x_keluarga")
@Where(clause = "is_delete = false")
public class KeluargaModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "keluarga_seq")
	@TableGenerator(name = "keluarga_seq", table= "tbl_sequence", pkColumnName = "seq_id",
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
	
	public BiodataModel getBiodataKeluarga() {
		return biodataKeluarga;
	}

	public void setBiodataKeluarga(BiodataModel biodataKeluarga) {
		this.biodataKeluarga = biodataKeluarga;
	}

	@Column(name = "biodata_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long biodataId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="biodata_id", foreignKey = @ForeignKey(name ="fk_biodata"))
	private BiodataModel biodataKeluarga;
	
	@Column(name = "family_tree_type_id", nullable = true, length=11, updatable = false, insertable = false)
	private long familyTreeTypeId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="family_tree_type_id", foreignKey = @ForeignKey(name ="fk_familyTree"))
	private FamilyTreeModel familyTree;
	
	@Column(name = "family_relation_id", nullable = true, length=11, updatable = false, insertable = false)
	private long familyRelationId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="family_relation_id", foreignKey = @ForeignKey(name ="fk_familyRelation"))
	private FamilyRelationModel familyRelation;
	
	@Column(name = "name", nullable = true, length=100)
	private String name;
	
	@Column(name = "jk", nullable = true, length=5)
	private String jk;
	
	@Column(name = "dob", nullable = true)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "education_level_id", nullable = true, length=11, updatable = false, insertable = false)
	private long educationLevelId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="education_level_id", foreignKey = @ForeignKey(name ="fk_educationLevel"))
	private EducationLvlModel educationLevel;
	
	@Column(name = "notes", nullable = true, length=1000)
	private String notes;
	
	@Column(name = "job", nullable = true, length=100)
	private String job;

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

	public BiodataModel getBiodata1() {
		return biodataKeluarga;
	}

	public void setBiodata1(BiodataModel biodata1) {
		this.biodataKeluarga = biodata1;
	}

	public long getFamilyTreeTypeId() {
		return familyTreeTypeId;
	}

	public void setFamilyTreeTypeId(long familyTreeTypeId) {
		this.familyTreeTypeId = familyTreeTypeId;
	}

	public FamilyTreeModel getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(FamilyTreeModel familyTree) {
		this.familyTree = familyTree;
	}

	public long getFamilyRelationId() {
		return familyRelationId;
	}

	public void setFamilyRelationId(long familyRelationId) {
		this.familyRelationId = familyRelationId;
	}

	public FamilyRelationModel getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(FamilyRelationModel familyRelation) {
		this.familyRelation = familyRelation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public EducationLvlModel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLvlModel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
